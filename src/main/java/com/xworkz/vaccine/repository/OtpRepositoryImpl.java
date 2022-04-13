package com.xworkz.vaccine.repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class OtpRepositoryImpl implements OtpRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public OtpRepositoryImpl() {
		System.out.println(this.getClass().getSimpleName()+" bean created");
	}

	@Override
	public int getOtpFromTable(int otp) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("getOtpFromTableByEmail");
			query.setParameter("OTP", otp);			
			return  (int) query.getSingleResult();
		} catch(Exception e){
			System.out.println(e);
		} finally {
			entityManager.close();
		}
		return 0;
		}
	}

