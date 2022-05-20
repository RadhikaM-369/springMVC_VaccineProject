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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="register_info")
@NamedQueries({
	@NamedQuery(name = "getUserNameFromDBbyUserName", 
		query = "select login.userName from RegisterEntity as login where login.userName=:userNamee"),
	
	@NamedQuery(name = "getPasswordFromDBbyUserName", 
	 query = "select loginpsw.pswd from RegisterEntity as loginpsw where loginpsw.userName=:userPassword"),
	
	@NamedQuery(name = "getLoginCountFromDbByUserName", 
	query = "select loginCountDB.loginCount from RegisterEntity as loginCountDB  where loginCountDB.userName=:uName"),
	
	@NamedQuery(name = "updateLoginCountByUserName", 
	query = "update RegisterEntity set loginCount=:LOGINCOUNT where userName=:USERNAME"),
	
	@NamedQuery(name = "updateConfirmPasswordByEmailID", 
	query = "update RegisterEntity set pswd=:confirmPassword,loginCount=0 where emailId=:email")
})
public class RegisterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASWORD")
	private String pswd;
	
	@Column(name="EMAILID")
	private String emailId;
	
	@Column(name="USERDOB")
	private String userDob;
	
	@Column(name="GENDERR")
	private String genderR;
	
	@Column(name="MOBILENO")
	private long mobileNo;
	
	@Column(name="LOGINCOUNT")
	private int loginCount;
}
