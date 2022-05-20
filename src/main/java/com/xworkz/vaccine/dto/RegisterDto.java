package com.xworkz.vaccine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
private String userName;
private String pswd;
private String emailId;
private String userDob;
private String genderR;
private long mobileNo;
}
