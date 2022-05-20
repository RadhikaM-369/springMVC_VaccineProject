package com.xworkz.vaccine.service;

public interface ResetPasswordService {
boolean validateResetPasswordInfo(String email,String newPassword,String confirmPassword);
boolean matchNewAndConfirmPassword(String newPassword, String confirmPassword);
String encodeConfirmPassword( String confirmPassword);
boolean updateEncodedConfirmPasswordByEmail(String encodeConfirmPassword,String email);
boolean sendResetPasswordToEmail(String confirmPassword,String email);

}
