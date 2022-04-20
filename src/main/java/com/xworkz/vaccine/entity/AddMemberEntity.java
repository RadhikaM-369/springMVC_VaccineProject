package com.xworkz.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="member_info")
public class AddMemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name="MemberName")
	private String name;
	@Column(name="YOB")
	private String yob;
	@Column(name="Gender")
	private String gender;
	@Column(name="IdProof")
	private String idProof;
	@Column(name="IdNumber")
	private String idNumber;
	@Column(name="VaccineType")
	private String vaccineType;
	@Column(name="Dose")
	private String dose;
	
}
