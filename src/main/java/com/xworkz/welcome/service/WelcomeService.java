package com.xworkz.welcome.service;

public interface WelcomeService {
public boolean validateEmail(String email);
boolean saveEmailAndOTP(String email,int otp);
int get4DigitOTP();
boolean sendOtpToEmail(String email,int otp);
}
