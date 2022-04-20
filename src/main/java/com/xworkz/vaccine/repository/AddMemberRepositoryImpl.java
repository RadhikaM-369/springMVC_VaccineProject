package com.xworkz.vaccine.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.AddMemberEntity;
@Repository
public class AddMemberRepositoryImpl implements AddMemberRepository{
	@Autowired
	private EntityManagerFactory entityManagerFactory; 
	@Override
	public boolean saveAddMemberEntity(AddMemberEntity addMemberEntity) {
		System.out.println("Invoked saveAddMemberEntity()");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(addMemberEntity);
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
