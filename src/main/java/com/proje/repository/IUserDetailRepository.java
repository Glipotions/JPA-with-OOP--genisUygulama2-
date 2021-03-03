package com.proje.repository;

import com.proje.entityFactory.IEntityFactory;
import com.proje.entityFactory.Impl.EntityFactoryImpl;
import com.proje.model.UserDetail;

public interface IUserDetailRepository {

	IEntityFactory entityFactory=new EntityFactoryImpl();
	
	boolean saveUserDetail (UserDetail userDetail);
	
	boolean updateUserDetail (UserDetail userDetail);
	
	boolean removeUserDetail (UserDetail userDetail);
	
	UserDetail findById(Integer id);
	
	UserDetail findByUsername (String username);
	
	UserDetail findWithAddressByUsername (String username);
	
	UserDetail findWithAdvertisementByUsername (String username);
	
}
