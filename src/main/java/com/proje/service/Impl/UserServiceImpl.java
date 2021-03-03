package com.proje.service.Impl;

import java.util.List;

import com.proje.model.User;
import com.proje.model.UserInfo;
import com.proje.repository.IUserRepository;
import com.proje.repository.Impl.UserRepositoryImpl;
import com.proje.service.IUserService;

public class UserServiceImpl implements IUserService{

	IUserRepository userRepository=new UserRepositoryImpl();

	@Override
	public boolean saveUser(User user) {
		return this.userRepository.saveUser(user);
	}

	@Override
	public boolean removeUser(User user) {
		return this.userRepository.removeUser(user);
	}

	@Override
	public User findById(Integer id) {
		return this.userRepository.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public User findWithUserDetailByUsername(String username) {
		return this.userRepository.findWithUserDetailByUsername(username);
	}

	@Override
	public List<User> findUsers() {
		return this.userRepository.findUsers();
	}

	@Override
	public List<User> findUsers(int firstResult, int maxResult) {
		return this.userRepository.findUsers(firstResult, maxResult);
	}

	@Override
	public int findUserCount() {
		return this.userRepository.findUserCount();
	}

	@Override
	public UserInfo findUserInfoByUsername(String username) {
		return this.userRepository.findUserInfoByUsername(username);
	}
}
