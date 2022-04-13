package com.xworkz.vaccine.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository {
	public int getOtpFromTable(int otp);
	
}
