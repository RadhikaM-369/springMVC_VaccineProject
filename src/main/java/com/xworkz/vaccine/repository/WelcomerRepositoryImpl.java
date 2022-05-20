package com.xworkz.vaccine.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.vaccine.entity.VaccineEntity;

@Repository
public class WelcomerRepositoryImpl implements WelcomeRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public WelcomerRepositoryImpl() {
		System.out.println(this.getClass().getSimpleName() + "  Bean created");
	}

	@Override
	public boolean saveWelcomeEntity(VaccineEntity vaccineEntity) {
		System.out.println("Invoked saveWelcomeEntity");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(vaccineEntity);
			entityManager.getTransaction().commit();
			System.out.println("Data saved");
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			if (entityManager != null) {	
				System.out.println("Entity manager is closed");
			} else {
				System.out.println("Data not saved");
			}
		}
		return false;
	}

	@Override
	public String getEmailFromDB(String email) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		System.out.println("Invoked getEmailFromDB");
			try {	
			Query query=entityManager.createNamedQuery("getEmailFromDB");
			query.setParameter("Email", email);
			return (String) query.getSingleResult();
			}catch(Exception exception) {
				//exception.printStackTrace();
			}
			return null;
		}
	@Override
	public int getMemberCountFromDB(String email) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		System.out.println("Invoked getMemberCountFromDB");
		int temp=0;
		try {	
			Query query=entityManager.createNamedQuery("getMemberCountFromDB");
			query.setParameter("Email", email);
			
			temp=(int) query.getSingleResult();
			System.out.println("Member_Count from getMemberCountFromDB REPO- "+temp);
			return temp;
			}catch(Exception exception) {
				//exception.printStackTrace();
			}
		return temp;
		
	}
	@Override
	public int updateMemberCount(String email,int count) {
		System.out.println("Invoked updateMemberCount()");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		int temp=0;
		try {
			Query query = entityManager.createNamedQuery("updateMemberCount");
			query.setParameter("Email", email);
			query.setParameter("Member_Count", count);
			temp=query.executeUpdate();		
			
			entityManager.getTransaction().commit();
			return temp;
		} catch (PersistenceException exception) {
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

