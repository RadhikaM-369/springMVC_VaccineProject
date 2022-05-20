package com.xworkz.vaccine.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.vaccine.entity.AddMemberEntity;
import com.xworkz.vaccine.entity.VaccineEntity;
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
	public List<AddMemberEntity> getAllMemberDataFromDB() {
		System.out.println("Invoked getAllMemberDataFromDB");
		EntityManager entityManager = null;
		try {
			entityManager = this.entityManagerFactory.createEntityManager();
			Query query = entityManager.createNamedQuery("getAllMemberDataFromDB");
			return (List<AddMemberEntity>) query.getResultList();
		} catch (PersistenceException exception) {
			System.out.println(exception);
		} finally {
			if(entityManager!=null) {
			entityManager.close();
		}
	}
		return null;
	}
	
}

/*
boolean isDataMemberSaved=this.saveAddMemberEntity(addMemberEntity);
int count=0;
if( isDataMemberSaved) {
int memberCount1=count++;
VaccineEntity vaccineEntity=new VaccineEntity();
vaccineEntity.setMemberCount(memberCount1);
System.out.println("Member Count- "+memberCount1);
}
return count;*/	
