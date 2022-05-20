package com.xworkz.vaccine.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.entity.RegisterEntity;
import com.xworkz.vaccine.exception.CheckCredentialsException;
import com.xworkz.vaccine.exception.InvalidLoginPasswordException;
import com.xworkz.vaccine.exception.InvalidLoginUserNameException;
import com.xworkz.vaccine.exception.UnregisteredPropertyException;
import com.xworkz.vaccine.repository.RegisterRepository;

@Service
public class LoginServiceImpl implements  LoginService{
	@Autowired
	private RegisterRepository registerRepo; 	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Override
	public boolean validateLoginInfo(String loginUserName, String passwordd) {
		boolean valid=false;
		System.out.println("Invoked validateRegisterDto()");
		
		if(loginUserName!=null && !loginUserName.isEmpty()  && loginUserName.length()>3 || loginUserName.length()<50) {
		valid=true;
		System.out.println("Valid user Name");		
		}else {
			InvalidLoginUserNameException invalidLoginUserNameException=
					new InvalidLoginUserNameException("Invalid UserName");
			throw invalidLoginUserNameException;	
		}
		if(passwordd!=null && !passwordd.isEmpty() && passwordd.length()>6 || passwordd.length()<15) {
			valid=true;
			System.out.println("Valid password");		
		}else {
			InvalidLoginPasswordException loginPasswordException=
					new InvalidLoginPasswordException("Invalid password");
			throw loginPasswordException;	
		}		
		return valid;
	}
	
	@Override
	public boolean decodePasswordAndCompare(String encodedPsword,String userName)  {
		System.out.println("Invoked decodePassword");
		boolean temp=false;
		try {	
		String userNameFromDB=registerRepo.getUserNameFromDBbyUserName(userName);
		System.out.println("userNameFromDB- "+userNameFromDB);
		String encodedPasswordFromDB=registerRepo.getPasswordFromDBbyUserName(userName);
		System.out.println("encodedPasswordFromDB- "+encodedPasswordFromDB);
		boolean decrypt=passwordEncoder.matches(encodedPsword,encodedPasswordFromDB);
		
		if(userName.equals(userNameFromDB) && passwordEncoder.matches(encodedPsword,encodedPasswordFromDB)) {
			/*RegisterEntity registerEntity=new RegisterEntity();*/
			int count=registerRepo.getLoginCountFromDbByUserName(userNameFromDB);
			System.out.println("count from reg DB- "+count);
			if(count<3) {
				System.out.println("is Decrypted - "+decrypt);
				System.out.println("User Name fro UI - "+userName+ " & UserName from DB- "+userNameFromDB);
				System.out.println("Credentials are matching");
				temp=true;
				return temp;
			}else {
			System.out.println("Count exceeded, user Blocked... ");	
			return temp;
			}}else {
				System.out.println("Credentials are not matching");
			}		
	}catch(CheckCredentialsException exception) {
		System.out.println(exception);
	}
		return false;
	}

	@Override
	public int blockUser(String encodedPsword, String userName) {
		System.out.println("Invoked blockUser");
		boolean temp=false;
		boolean isDecodeAndCompare=this.decodePasswordAndCompare(encodedPsword, userName);
		if(isDecodeAndCompare) {
			System.out.println("decodePasswordAndCompare() is"+isDecodeAndCompare);
		}else {
			String userNameFromDB=registerRepo.getUserNameFromDBbyUserName(userName);
			int loginCountfromDB=registerRepo.getLoginCountFromDbByUserName(userNameFromDB);
			System.out.println("LoginCount from getLoginCountFromDbByUserName is- "+loginCountfromDB);
			if(loginCountfromDB>=3) {
				System.out.println("exceeded max login attempts");
				return loginCountfromDB;				
			}else {
				loginCountfromDB++;
				int incrementLoginCount=registerRepo.updateLoginCountByUserName(loginCountfromDB, userNameFromDB);
				System.out.println("loginCount after updateLoginCountByUserName is- "+incrementLoginCount);
				return loginCountfromDB;
			}	
		}
		return 0;
	}
	}


/*
int memberCount1=welcomeRepo.getMemberCountFromDB(WelcomeController.email);
System.out.println(" Membercount from getMemberCountFromDB- "+memberCount1);
if(memberCount1>=4) {
	System.out.println("Cannot add more than 4 members");
	return false;
}else {			
boolean isEntitySaved = addMemberRepo.saveAddMemberEntity(addMemberEntity);
memberCount1++;
welcomeRepo.updateMemberCount(WelcomeController.email,memberCount1);
isEntitySaved=true;
return isEntitySaved;
*/



//boolean isPasswordDecrypted=passwordEncoder.matches(encodedPasswordFromDB, encodedPasswordFromDB)
	//	System.out.println("password from encodedPasswordFromDB- "+encodedPasswordFromDB);
	//	System.out.println("Is password Decrypted - "+isPasswordDecrypted);