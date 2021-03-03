package com.proje.repository.Impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.UserDetail;
import com.proje.repository.IUserDetailRepository;

public class UserDetailRepositoryImpl implements IUserDetailRepository{
	private EntityManager entityManager=entityFactory.getEntityManager();
	
	private EntityTransaction transaction=this.entityManager.getTransaction();

	@Override
	public boolean saveUserDetail(final UserDetail userDetail) {
		try {
			this.transaction.begin();
			
			this.entityManager.persist(userDetail);
			
			this.transaction.commit();
		} catch (RuntimeException e) {
			System.err.println("Hata : "+e);
			try {
			
				this.transaction.rollback();
			
			} catch (RollbackException e2) {
				
				System.err.println("Hata : "+e2);
			
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUserDetail(final UserDetail userDetail) {
		try {
			this.transaction.begin();
			
			this.entityManager.merge(userDetail);
			
			this.transaction.commit();
		} catch (RuntimeException e) {
			System.err.println("Hata : "+e);
			try {
			
				this.transaction.rollback();
			
			} catch (RollbackException e2) {
				
				System.err.println("Hata : "+e2);
			
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean removeUserDetail(UserDetail userDetail) {
		try {
			if(this.entityManager.contains(userDetail)) {
				this.entityManager.remove(userDetail);
			}else {
				UserDetail deleteUserDetail = this.findById(userDetail.getUserDetailId());
				this.entityManager.remove(deleteUserDetail);
			}
		} catch (RuntimeException e) {
			System.err.println("Hata : "+e);
			try {
			
				this.transaction.rollback();
			
			} catch (RollbackException e2) {
				
				System.err.println("Hata : "+e2);
			
			}
			return false;
		}
		return true;
	}

	@Override
	public UserDetail findById(final Integer id) {

		return null;
	}

	@Override
	public UserDetail findByUsername(final String username) {
		UserDetail userDetail=null;
		
		try {
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findByUsername", UserDetail.class);
			typedQuery.setParameter("username", username);
			
			userDetail=typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
			
		return userDetail;
	}

	@Override
	public UserDetail findWithAddressByUsername(final String username) {
		UserDetail userDetail=null;
		try {
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithAddressByUsername", UserDetail.class);
			typedQuery.setParameter("username", username);
			
			
			userDetail=typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
		return userDetail;
	}

	@Override
	public UserDetail findWithAdvertisementByUsername(final String username) {
		UserDetail userDetail=null;
		try {
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithAdvertisementByUsername", UserDetail.class);
			typedQuery.setParameter("username", username);
			
			
			userDetail=typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
		return userDetail;
	}
}
