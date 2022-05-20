package com.xworkz.vaccine.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResetPasswordRepositoryImpl implements ResetPasswordRepository{

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public ResetPasswordRepositoryImpl() {
		System.out.println(this.getClass().getSimpleName()+" bean created");
	}

	@Override
	public boolean updateConfirmPasswordByEmailID(String confirmPassword, String email) {
		System.out.println("Invoked updateConfirmPasswordByEmailID");
		boolean temp=false;
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Query query = entityManager.createNamedQuery("updateConfirmPasswordByEmailID");
			query.setParameter("confirmPassword", confirmPassword);
			query.setParameter("email", email);
			
			query.executeUpdate();				
			entityManager.getTransaction().commit();
			temp=true;
			return temp;
		}catch (PersistenceException exception) {
			entityManager.getTransaction().rollback();
			exception.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return temp;
	}	
}
