package com.proje.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Education.findEducation", query="SELECT e FROM Education e"),
	@NamedQuery(name = "Education.findById",query="SELECT e FROM Education e WHERE e.educationId = :educationId"),
	@NamedQuery(name = "Education.findWithAdvertisementByEducationId",
				query= "SELECT e FROM Education e LEFT JOIN FETCH e.advertisements WHERE e.educationId = :educationId")
})
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;
	
	private String educationName;
	
	private int lisanceYear;
	
	@ManyToMany(mappedBy = "educations",fetch = FetchType.LAZY)
	private List<Advertisement>advertisements=new ArrayList<Advertisement>();
	
	public Education() {

	}

	public Education(String educationName, int lisanceYear) {
		super();
		this.educationName = educationName;
		this.lisanceYear = lisanceYear;
	}

	public Integer getEducationId() {
		return educationId;
	}

	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public int getLisanceYear() {
		return lisanceYear;
	}

	public void setLisanceYear(int lisanceYear) {
		this.lisanceYear = lisanceYear;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	@Override
	public String toString() {
		return "Education [educationId=" + educationId + ", educationName=" + educationName + ", lisanceYear="
				+ lisanceYear + ", advertisements=" + advertisements + "]";
	}
	
	
	
}
