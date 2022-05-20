package com.xworkz.vaccine.repository;

import com.xworkz.vaccine.entity.RegisterEntity;

public interface RegisterRepository {
 boolean SaveUserRegistrationEntity(RegisterEntity registerEntity);
 String getUserNameFromDBbyUserName(String userName);
 String getPasswordFromDBbyUserName(String userName);
int getLoginCountFromDbByUserName(String userName);
int updateLoginCountByUserName(int loginCount,String userName);
}
