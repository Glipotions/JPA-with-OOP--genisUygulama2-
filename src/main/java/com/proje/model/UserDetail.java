package com.proje.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.proje.model.util.PhoneType;

@Entity
@NamedQueries({
	@NamedQuery(name = "UserDetail.findByUsername",
				query="SELECT ud FROM UserDetail ud WHERE ud.user.username = :username"),
	@NamedQuery(name = "UserDetail.findWithAddressByUsername",
				query="SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.addresses WHERE ud.user.username = :username"),
	@NamedQuery(name = "UserDetail.findWithAdvertisementByUsername",
	query="SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.advertisements WHERE ud.user.username = :username")
})
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userDetailId;
	
	private String firstName;
	
	private String lastName;
	
	private Date date;
	
	@ElementCollection
	@JoinTable(name="userDetail_phoneNumber", joinColumns = @JoinColumn(name ="userDetailId"))
	@MapKeyColumn(name="phoneType")
	@Column(name="phoneNumber")
	private Map<PhoneType, String> phonesNumber=new HashMap<PhoneType, String>();
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name="userDetail_address", joinColumns = @JoinColumn(name="userDetailId"))
	private List<Address> addresses=new ArrayList<Address>();
	
	@OneToMany(mappedBy = "userDetail",fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST , CascadeType.REMOVE, CascadeType.MERGE})
	private List<Advertisement>advertisements=new ArrayList<Advertisement>();
	
	@OneToOne(mappedBy = "userDetail",fetch = FetchType.LAZY)
	private User user;
	
	public UserDetail() {
		// TODO Auto-generated constructor stub
	}

	
	
	public UserDetail(String firstName, String lastName, Date date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
	}


	public void addPhoneNumber(PhoneType key, String value) {
		this.phonesNumber.put(key, value);
	}
	
	public Integer getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map<PhoneType, String> getPhonesNumber() {
		return phonesNumber;
	}

	public void setPhonesNumber(Map<PhoneType, String> phonesNumber) {
		this.phonesNumber = phonesNumber;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", date=" + date + ", phonesNumber=" + phonesNumber + "]";
	}
	
	
	
}
