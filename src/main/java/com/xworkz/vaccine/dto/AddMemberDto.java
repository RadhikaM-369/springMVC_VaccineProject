package com.xworkz.vaccine.dto;

import lombok.Data;

@Data
public class AddMemberDto {
	private String name;
	private String  yob;
	private String gender;
	private String idProof;
	private String idNumber;
	private String vaccineType;
	private String dose;
}
