package com.xworkz.vaccine.service;

public interface LoginService {
boolean validateLoginInfo(String userName,String password);
boolean decodePasswordAndCompare(String encodedPsword,String userName);
int blockUser(String encodedPsword,String userName);
}
