package com.xworkz.vaccine.repository;

import com.xworkz.vaccine.entity.VaccineEntity;

public interface WelcomeRepository {
boolean saveWelcomeEntity(VaccineEntity welcomeEntity); 
String getEmailFromDB(String email);
public int updateMemberCount(String email,int count);
public int getMemberCountFromDB(String email);
}
