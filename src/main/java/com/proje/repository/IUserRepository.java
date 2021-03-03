package com.proje.repository;

import java.util.List;

import com.proje.entityFactory.IEntityFactory;
import com.proje.entityFactory.Impl.EntityFactoryImpl;
import com.proje.model.User;
import com.proje.model.UserInfo;

public interface IUserRepository {

	IEntityFactory entityFactory=new EntityFactoryImpl();
	
	boolean saveUser(User user);
	
	boolean removeUser(User user);
	
	User findById(Integer id);
	
	User findByUsername(String username);
	
	User findWithUserDetailByUsername(String username);
	
	List<User> findUsers();
	
	List<User> findUsers(int firstResult, int maxResult);
	
	int findUserCount();
	
	UserInfo findUserInfoByUsername(String username);
}
