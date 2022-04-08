package com.xworkz.welcome.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "welcome_info")
public class WelcomeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int userId;
	@Column(name = "Email")
	private String email;
	@Column(name = "OTP")
	private int otp;
	
	public WelcomeEntity(String email, int otp) {
		super();
		this.email = email;
		this.otp = otp;
	}
	
	

}
