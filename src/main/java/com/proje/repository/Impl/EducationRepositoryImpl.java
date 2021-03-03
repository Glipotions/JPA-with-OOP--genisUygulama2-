package com.proje.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.Education;
import com.proje.repository.IEducationRepository;

public class EducationRepositoryImpl implements IEducationRepository{
	private EntityManager entityManager=entityFactory.getEntityManager();
	
	private EntityTransaction transaction=this.entityManager.getTransaction();

	@Override
	public boolean saveEducation(final Education education) {
		try {
			this.transaction.begin();
			
			this.entityManager.persist(education);
			
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
	public boolean updateEducation(final Education education) {
		try {
			this.transaction.begin();
			
			this.entityManager.merge(education);
			
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
	public boolean removeEducation(final Education education) {
		try {
			if(this.entityManager.contains(education)) {
				this.entityManager.remove(education);
			}else {
				Education deleteEducation = this.findById(education.getEducationId());
				this.entityManager.remove(deleteEducation);
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
	public Education findById(final Integer id) {
		Education education=null;
		
		try {
			TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findById", Education.class);
			typedQuery.setParameter("educationId", id);
			
			education=typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
			
		return education;
	}

	@Override
	public List<Education> findEducations() {
		List<Education> educations=null;
		try {
			TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findEducation", Education.class);
			
			educations=typedQuery.getResultList();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
		return educations;
	}

	@Override
	public Education findWithAdvertsementById(final Integer id) {
		Education educations=null;
		try {
			TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findWithAdvertisementByEducationId", Education.class);
			typedQuery.setParameter("educationId", id);
			
			
			educations=typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.err.println("Hata : "+e);
		}
		return educations;
	}
}
