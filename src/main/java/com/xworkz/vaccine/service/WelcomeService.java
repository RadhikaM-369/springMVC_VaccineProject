package com.xworkz.vaccine.service;

public interface WelcomeService {
public boolean validateEmail(String email);
boolean verifyEmailFromDb(String email);
boolean saveEmailAndOTP(String email,int otp);
int getFourDigitOTP();
boolean sendOtpToEmail(String email,int otp);
}
