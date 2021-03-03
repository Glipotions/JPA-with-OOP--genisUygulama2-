package com.proje.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.Advertisement;
import com.proje.repository.IAdvertisementRepository;

public class AdvertisementRepositoryImpl implements IAdvertisementRepository{
	
	private EntityManager entityManager=entityFactory.getEntityManager();
	
	private EntityTransaction transaction=this.entityManager.getTransaction();

	@Override
	public boolean saveAdvertisement(final Advertisement advertisement) {

		try {
			this.transaction.begin();
			
			this.entityManager.persist(advertisement);
			
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
	public boolean updateAdvertisement(final Advertisement advertisement) {
		
		try {
			this.transaction.begin();
			
			this.entityManager.merge(advertisement);
			
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
	public boolean removeAdvertisement(final Advertisement advertisement) {
		try {
			if(this.entityManager.contains(advertisement)) {
				this.entityManager.remove(advertisement);
			}else {
				Advertisement deleteAdvertisement = this.findById(advertisement.getAdvertisementId());
				this.entityManager.remove(deleteAdvertisement);
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
	public Advertisement findById(final Integer id) {
		Advertisement advertisement=null;
		
		try {
			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findById", Advertisement.class);
			typedQuery.setParameter("advertisementId", id);
			
			advertisement=typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
			
		return advertisement;
	}

	@Override
	public List<Advertisement> findByUsername(final String username) {
		List<Advertisement> advertisements=null;
		try {
			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findByUsername", Advertisement.class);
			typedQuery.setParameter("username", username);
			
			advertisements=typedQuery.getResultList();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
		return advertisements;
	}

	@Override
	public List<Advertisement> findAdvertisements() {
		List<Advertisement> advertisements=null;
		try {
			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findAdvertisement", Advertisement.class);
			
			advertisements=typedQuery.getResultList();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
		return advertisements;
	}

	@Override
	public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {
		List<Advertisement> advertisements=null;
		try {
			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findAdvertisement", Advertisement.class);
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);
			
			
			advertisements=typedQuery.getResultList();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
		return advertisements;
	}
	
}
