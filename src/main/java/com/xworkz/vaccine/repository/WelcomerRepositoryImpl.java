package com.xworkz.vaccine.repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.VaccineEntity;

@Repository
public class WelcomerRepositoryImpl implements WelcomeRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;	
	
	public WelcomerRepositoryImpl() {
		System.out.println(this.getClass().getSimpleName()+ "  Bean created");
	}

	@Override
	public boolean saveWelcomeEntity(VaccineEntity welcomeEntity) {
		System.out.println("Invoked saveWelcomeEntity()");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(welcomeEntity);
			entityManager.getTransaction().commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			if (entityManager != null) {
				System.out.println("Data saved");
			} else {
				System.out.println("Data not saved");
			}
		}
		return false;
	}

}
