package com.xworkz.vaccine.service;

public interface RegisterUserService {
	public boolean validateRegisterDto(String userName, String passwordd, String emailId,
			String userDOB,	String userGender, long mobileNo);
	public String encodePassword(String pasword);
	public boolean sendPasswordToEmail(String email,String pasword);
	public boolean saveValidRegisterWithEncodedPswdInDB(String userName, String passwordd, String emailId,
			String userDOB,	String userGender, long mobileNo);
}
