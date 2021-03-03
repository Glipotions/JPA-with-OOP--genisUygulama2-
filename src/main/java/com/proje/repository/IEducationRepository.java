package com.proje.repository;

import java.util.List;

import com.proje.entityFactory.IEntityFactory;
import com.proje.entityFactory.Impl.EntityFactoryImpl;
import com.proje.model.Education;

public interface IEducationRepository {
	
	IEntityFactory entityFactory=new EntityFactoryImpl();
	
	boolean saveEducation(Education education);
	
	boolean updateEducation (Education education);
	
	boolean removeEducation (Education education);
	
	Education findById(Integer id);
	
	List<Education> findEducations();
	
	Education findWithAdvertsementById(Integer id);
	
}
