package com.proje.service.Impl;

import java.util.List;

import com.proje.model.Education;
import com.proje.repository.IEducationRepository;
import com.proje.repository.Impl.EducationRepositoryImpl;
import com.proje.service.IEducationService;

public class EducationServiceImpl implements IEducationService{
	IEducationRepository educationRepository=new EducationRepositoryImpl();

	@Override
	public boolean saveEducation(Education education) {
		return this.educationRepository.saveEducation(education);
	}

	@Override
	public boolean updateEducation(Education education) {
		return this.educationRepository.updateEducation(education);
	}

	@Override
	public boolean removeEducation(Education education) {
		return this.educationRepository.removeEducation(education);
	}

	@Override
	public Education findById(Integer id) {
		return this.educationRepository.findById(id);
	}

	@Override
	public List<Education> findEducations() {
		return this.educationRepository.findEducations();
	}

	@Override
	public Education findWithAdvertsementById(Integer id) {
		return this.educationRepository.findWithAdvertsementById(id);
	}
	
}
