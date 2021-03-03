package com.proje.service.Impl;

import com.proje.model.UserDetail;
import com.proje.repository.IUserDetailRepository;
import com.proje.repository.Impl.UserDetailRepositoryImpl;
import com.proje.service.IUserDetailService;

public class UserDetailServiceImpl implements IUserDetailService{
	IUserDetailRepository userDetailRepository=new UserDetailRepositoryImpl();

	@Override
	public boolean saveUserDetail(UserDetail userDetail) {
		return this.userDetailRepository.saveUserDetail(userDetail);
	}

	@Override
	public boolean updateUserDetail(UserDetail userDetail) {
		return this.userDetailRepository.updateUserDetail(userDetail);
	}

	@Override
	public boolean removeUserDetail(UserDetail userDetail) {
		return this.userDetailRepository.removeUserDetail(userDetail);
	}

	@Override
	public UserDetail findById(Integer id) {
		return this.userDetailRepository.findById(id);
	}

	@Override
	public UserDetail findByUsername(String username) {
		return this.userDetailRepository.findByUsername(username);
	}

	@Override
	public UserDetail findWithAddressByUsername(String username) {
		return this.userDetailRepository.findWithAddressByUsername(username);
	}

	@Override
	public UserDetail findWithAdvertisementByUsername(String username) {
		return this.userDetailRepository.findWithAdvertisementByUsername(username);
	}
	
}
