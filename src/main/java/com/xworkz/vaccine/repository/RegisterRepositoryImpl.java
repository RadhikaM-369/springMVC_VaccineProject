package com.xworkz.vaccine.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.vaccine.entity.RegisterEntity;
@Repository
public class RegisterRepositoryImpl implements RegisterRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public RegisterRepositoryImpl() {
		System.out.println(this.getClass().getSimpleName()+" Bean created");
	}

	@Override
	public boolean SaveUserRegistrationEntity(RegisterEntity registerEntity) {
		System.out.println("Invoked SaveUserRegistrationEntity");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(registerEntity);
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
	public String getUserNameFromDBbyUserName(String userName) {
		System.out.println("Invoked getUserNameFromDBbyUserName");
	 	EntityManager entityManager = this.entityManagerFactory.createEntityManager();
	 	String result=null;
	 	try {	
		Query query=entityManager.createNamedQuery("getUserNameFromDBbyUserName");
		query.setParameter("userNamee", userName);
		result=(String) query.getSingleResult();
		System.out.println("UserName from DB "+result);
		return result;
	 	}catch(Exception exception) {
			//exception.printStackTrace();
		}
		return result;
	}

	@Override
	public String getPasswordFromDBbyUserName(String userName) {
		System.out.println("Invoked getPasswordFromDBbyUserName");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		String result=null;
		try {	
		Query query=entityManager.createNamedQuery("getPasswordFromDBbyUserName");
		query.setParameter("userPassword", userName);
		result=(String) query.getSingleResult();
		System.out.println("Password from DB "+result);
		return result;
	 	}catch(Exception exception) {
			//exception.printStackTrace();
		}
		return result;
	}

	@Override
	public int getLoginCountFromDbByUserName(String userName) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		System.out.println("Invoked getLoginCountFromDbByUserName");
		int temp=0;
		try {	
			Query query=entityManager.createNamedQuery("getLoginCountFromDbByUserName");
			query.setParameter("uName", userName);
			temp=(int) query.getSingleResult();
			System.out.println("LoginCount from getLoginCountFromDbByUserName REPO- "+temp);
			return temp;
			}catch(Exception exception) {
				//exception.printStackTrace();
			}
		return temp;		
	}		

	@Override
	public int updateLoginCountByUserName(int loginCount,String userName) {
		System.out.println("Invoked updateLoginCountByUserName");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		int temp=0;
		try {
			Query query = entityManager.createNamedQuery("updateLoginCountByUserName");
			query.setParameter("USERNAME", userName);
			query.setParameter("LOGINCOUNT", loginCount);
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
