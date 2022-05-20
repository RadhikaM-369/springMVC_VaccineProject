package com.xworkz.vaccine.repository;

public interface ResetPasswordRepository {
boolean updateConfirmPasswordByEmailID(String confirmPassword,String email);

}
