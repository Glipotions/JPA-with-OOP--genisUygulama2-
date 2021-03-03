package com.proje.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.User;
import com.proje.model.UserInfo;
import com.proje.repository.IUserRepository;

public class UserRepositoryImpl implements IUserRepository{

	private EntityManager entityManager=entityFactory.getEntityManager();
	
	private EntityTransaction transaction=this.entityManager.getTransaction();
	
	@Override
	public boolean saveUser(final User user) {
		try {
			this.transaction.begin();
			
			this.entityManager.persist(user);
			
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
	public boolean removeUser(final User user) {
		try {
			if(this.entityManager.contains(user)) {
				this.entityManager.remove(user);
			}else {
				User deleteUser = this.findById(user.getUserId());
				this.entityManager.remove(deleteUser);
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
	public User findById(final Integer id) {
		User user=null;
		
		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findById", User.class);
			typedQuery.setParameter("userId", id);
			
			user=typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
			
		return user;
	}

	@Override
	public User findByUsername(final String username) {
		User user=null;
		
		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findByUsername", User.class);
			typedQuery.setParameter("username", username);
			
			user=typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
			
		return user;
	}

	@Override
	public User findWithUserDetailByUsername(final String username) {
		User user=null;
		
		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findWithUserDetailByUsername", User.class);
			typedQuery.setParameter("username", username);
			
			user=typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
			
		return user;
	}

	@Override
	public List<User> findUsers() {
		List<User> users=null;
		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUser", User.class);
			
			users=typedQuery.getResultList();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
		return users;
	}

	@Override
	public List<User> findUsers(final int firstResult,final int maxResult) {
		List<User> users=null;
		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUser", User.class);
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);
			users=typedQuery.getResultList();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
		return users;
	}

	@Override
	public int findUserCount() {
		int count=0;
		try {
			Query query=this.entityManager.createNamedQuery("User.count");
			count=(int) query.getSingleResult();
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
			
		return count;
	}

	@Override
	public UserInfo findUserInfoByUsername(String username) {
		UserInfo userInfo=null;
		try {
			TypedQuery<UserInfo> typedQuery = this.entityManager.createNamedQuery("User.userInfoByUsername", UserInfo.class);
			typedQuery.setParameter("username", username);
			
			userInfo=typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
			
		return userInfo;
	}

}
