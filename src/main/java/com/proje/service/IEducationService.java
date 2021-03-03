package com.proje.service;

import java.util.List;

import com.proje.model.Education;

public interface IEducationService {
	boolean saveEducation(Education education);
	
	boolean updateEducation (Education education);
	
	boolean removeEducation (Education education);
	
	Education findById(Integer id);
	
	List<Education> findEducations();
	
	Education findWithAdvertsementById(Integer id);
}
