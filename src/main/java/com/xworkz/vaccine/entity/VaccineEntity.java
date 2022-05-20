package com.xworkz.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "welcome_info")
@NamedQueries({
	@NamedQuery(name = "getOtpFromTable", 
			   query = "select vaccine.otp from VaccineEntity as vaccine where vaccine.otp=:OTP"),
	@NamedQuery(name = "getEmailFromDB", 
	   			query = "select vaccine.email from VaccineEntity as vaccine where vaccine.email=:Email"),
	@NamedQuery(name = "getMemberCountFromDB", 
		query = "select vaccine.memberCount from VaccineEntity as vaccine where vaccine.email=:Email"),
	@NamedQuery(name = "updateMemberCount", 
	query = "update VaccineEntity set memberCount=:Member_Count where email=:Email")
})

public class VaccineEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int userId;
	@Column(name = "Email")
	private String email;
	@Column(name = "OTP")
	private int otp;
	@Column(name = "Member_Count")
	private int memberCount;

	
	public VaccineEntity(String email, int otp) {
		super();
		this.email = email;
		this.otp = otp;
	}
}
