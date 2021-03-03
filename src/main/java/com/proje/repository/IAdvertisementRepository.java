package com.proje.repository;

import java.util.List;
import com.proje.entityFactory.IEntityFactory;
import com.proje.entityFactory.Impl.EntityFactoryImpl;
import com.proje.model.Advertisement;

public interface IAdvertisementRepository {
	
	IEntityFactory entityFactory=new EntityFactoryImpl();

	boolean saveAdvertisement(Advertisement advertisement);
	
	boolean updateAdvertisement(Advertisement advertisement);
	
	boolean removeAdvertisement(Advertisement advertisement);
	
	Advertisement findById(Integer id);
	
	List<Advertisement> findByUsername(String username);
	
	List<Advertisement> findAdvertisements();
	
	List<Advertisement> findAdvertisementEntities(int firstResult , int maxResult);
}
