package com.xworkz.vaccine.service;

import org.springframework.stereotype.Service;

@Service
public interface OtpService {
	boolean validateOTP(int otp);

	boolean verifyOtpFromDb(int otp);
}
