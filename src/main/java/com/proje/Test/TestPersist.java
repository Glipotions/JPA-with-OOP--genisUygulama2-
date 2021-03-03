package com.proje.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.proje.model.Address;
import com.proje.model.Advertisement;
import com.proje.model.Education;
import com.proje.model.User;
import com.proje.model.UserDetail;
import com.proje.model.util.PhoneType;
import com.proje.repository.IAdvertisementRepository;
import com.proje.repository.IEducationRepository;
import com.proje.repository.IUserDetailRepository;
import com.proje.repository.Impl.AdvertisementRepositoryImpl;
import com.proje.repository.Impl.EducationRepositoryImpl;
import com.proje.repository.Impl.UserDetailRepositoryImpl;
import com.proje.service.IUserService;
import com.proje.service.Impl.UserServiceImpl;

public class TestPersist {

	private static IUserService userRepository=new UserServiceImpl();
	private static IAdvertisementRepository advertisementRepository=new AdvertisementRepositoryImpl();
	private static IEducationRepository educationRepository=new EducationRepositoryImpl();
	private static IUserDetailRepository userDetailRepository=new UserDetailRepositoryImpl();
	
	
	public static void main(String[] args) {
//		insertData();
		
//		User user=userRepository.findById(3);
//		System.out.println(user);
		
		
//		System.out.println(userRepository.findByUsername("Glipotions"));
		
		System.out.println(userRepository.findUserCount());
		
	}
	
	
	public static void insertData() {
		User user1=new User("Glipotions", "12345", new Date());
		User user2=new User("Glipofrositoksin", "2113", new Date());
		User user3=new User("Glipiotigers", "52145", new Date());
		
		userRepository.saveUser(user1);
		userRepository.saveUser(user2);
		userRepository.saveUser(user3);
		
		UserDetail userDetail1=new UserDetail("Hamza", "Kavak", new Date());
		UserDetail userDetail2=new UserDetail("Erkam", "Kavak", new Date());
		UserDetail userDetail3=new UserDetail("Mustafa", "Kavak", new Date());
		
		userDetailRepository.saveUserDetail(userDetail1);
		userDetailRepository.saveUserDetail(userDetail2);
		userDetailRepository.saveUserDetail(userDetail3);
		
		
		Education education1=new Education("Yazýlým Mühendisliði", 2018);
		Education education2=new Education("Bilgisayar Mühendisliði", 2024);
		Education education3=new Education("Elektrik Elektronik Mühendisliði", 2021);
		Education education4=new Education("Makine Mühendisliði", 2023);
		Education education5=new Education("Çevre mühendisliði", 2022);
		
//		educations1.add(education3);
//		educations2.add(education4);
//		educations3.add(education5);
		
		educationRepository.saveEducation(education1);
		educationRepository.saveEducation(education2);
		educationRepository.saveEducation(education3);
		educationRepository.saveEducation(education4);
		educationRepository.saveEducation(education5);
		
		Advertisement advertisement1=new Advertisement("Yazýlým Mühendisi Aranýyor", "9-6 arasý çalýþacak 5k maaþ", "yazýlým bilmesi");
		Advertisement advertisement2=new Advertisement("Bilgisayar Mühendisi aranýyor", "9-6.30 arasý çalýþacak 7k maaþ",
										"3 üstü ortalama ve donanýmsal ve yazýlýmsal olarak üstün bilgisayar bilgisi");
		Advertisement advertisement3=new Advertisement("Elektrik Elektronik Mühendisi Aranýyor", "8-7 arasý çalýþacak 9k maaþ",
										"hem elektrik hem elektronik bilgisi olacak güç elektroniði ve yazýlýmlar üzerinde uzmanlaþmýþ olmasý istenmektedir.");
		Advertisement advertisement4=new Advertisement("Makine Mühendisi aranýyor", "9-6.30 arasý çalýþacak 7.5k maaþ", 
										"Autocad catia gibi çizim programlarýnda profesyonel olacak");
		Advertisement advertisement5=new Advertisement("Çevre mühendisi aranýyor", "9-5.30 arasý çalýþacak 3.5 k maaþ", "Çevre mühendisi olmasý");
		
		advertisementRepository.saveAdvertisement(advertisement1);
		advertisementRepository.saveAdvertisement(advertisement2);
		advertisementRepository.saveAdvertisement(advertisement3);
		advertisementRepository.saveAdvertisement(advertisement4);
		advertisementRepository.saveAdvertisement(advertisement5);
		

		
//		userRepository.saveUser(user1);
//		userRepository.saveUser(user2);
//		userRepository.saveUser(user3);
//		
		List<Education> educations1= new ArrayList<Education>();
		List<Education> educations2= new ArrayList<Education>();
		List<Education> educations3= new ArrayList<Education>();
		
		Address address1=new Address("Kaptaný Derya", "34. sokak", 34039, "istanbul");
		Address address2=new Address("Menekþe", "12. sokak", 3539, "istanbul");
		Address address3=new Address("Atatürk Caddesi", "42. sokak", 34039, "Aðrý");
		Address address4=new Address("Polat Caddesi", "Memati sokak", 01543, "Adana");
		
		List<Advertisement> advertisements1=new ArrayList<Advertisement>();
		List<Advertisement> advertisements2=new ArrayList<Advertisement>();
		List<Advertisement> advertisements3=new ArrayList<Advertisement>();
		
		advertisements1.add(advertisement1);
		advertisements2.add(advertisement2);
		advertisements3.add(advertisement3);
		
		educations1.add(education1);
		educations2.add(education2);
		educations3.add(education3);
		
		List<Address> adresler1=new ArrayList<Address>();
		List<Address> adresler2=new ArrayList<Address>();
		List<Address> adresler3=new ArrayList<Address>();
		
		adresler1.add(address1);
		adresler2.add(address2);
		adresler3.add(address3);
		
		
		userDetail1.setAddresses(adresler1);
		userDetail2.setAddresses(adresler2);
		userDetail3.setAddresses(adresler3);
		
		userDetail1.addPhoneNumber(PhoneType.CELL, "0505554526");
		userDetail2.addPhoneNumber(PhoneType.HOME, "021264518");
		userDetail3.addPhoneNumber(PhoneType.WORK, "4441234");
		
		user1.setUserDetail(userDetail1);
		user2.setUserDetail(userDetail2);
		user3.setUserDetail(userDetail3);
		
		userDetail1.setUser(user1);
		userDetail2.setUser(user2);
		userDetail3.setUser(user3);
		
		userDetail1.setAdvertisements(advertisements1);
		userDetail2.setAdvertisements(advertisements2);
		userDetail3.setAdvertisements(advertisements3);
		
		education1.setAdvertisements(advertisements1);
		education2.setAdvertisements(advertisements2);
		education3.setAdvertisements(advertisements3);
		
//		advertisement1.setUserDetail(userDetail1);
//		advertisement2.setUserDetail(userDetail2);
//		advertisement3.setUserDetail(userDetail3);
//		
//		advertisement1.setEducations(educations1);
//		advertisement2.setEducations(educations2);
//		advertisement3.setEducations(educations3);

//		

//		

	}
	
	public static void digerveriler() {
		

		
	}
	
}
