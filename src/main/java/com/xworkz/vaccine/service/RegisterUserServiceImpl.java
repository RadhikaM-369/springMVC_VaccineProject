package com.xworkz.vaccine.service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.entity.RegisterEntity;
import com.xworkz.vaccine.exception.UnregisteredPropertyException;
import com.xworkz.vaccine.repository.RegisterRepositoryImpl;
@Service
public class RegisterUserServiceImpl implements RegisterUserService{
	@Autowired
	private RegisterRepositoryImpl registerRepo;
	@Autowired
	private MailSender mailSender;	
	
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	public RegisterUserServiceImpl() {
		System.out.println(this.getClass().getSimpleName()+" bean created");
	}
	@Override
	public boolean validateRegisterDto(String userName, String passwordd, String emailId,
			String userDOB,	String userGender, long mobileNo) throws UnregisteredPropertyException {
		boolean valid=false;
		System.out.println("Invoked validateRegisterDto()");
		try{
		if(userName!=null || !userName.isEmpty()  || userName.length()>3 || userName.length()<50) {
		valid=true;
		System.out.println("Valid user Name");
		
		}else {
			UnregisteredPropertyException unregisteredPropertyException=
					new UnregisteredPropertyException("Invalid UserName");
			throw unregisteredPropertyException;	
		}
		if(passwordd!=null || !passwordd.isEmpty() || passwordd.length()>6 || passwordd.length()<15) {
			valid=true;
			System.out.println("Valid password");
		
		}else {
			UnregisteredPropertyException unregisteredPropertyException=
					new UnregisteredPropertyException("Invalid password");
			throw unregisteredPropertyException;	
		}
		if(userDOB!=null || !userDOB.isEmpty() || userDOB.length()==10) {
			valid=true;
			System.out.println("Valid User DOB");
		
		}else {
			UnregisteredPropertyException unregisteredPropertyException=
					new UnregisteredPropertyException("Invalid User DOB");
			throw unregisteredPropertyException;	
		}
		if(emailId!=null || !emailId.isEmpty() || emailId.length()>3 || emailId.length()<50||
				emailId.contains("@")||emailId.endsWith(".com")) {
			valid=true;
			System.out.println("Valid emailId");
		
		}else {
			UnregisteredPropertyException unregisteredPropertyException=
					new UnregisteredPropertyException("Invalid emailId");
			throw unregisteredPropertyException;	
		}
		if(userGender!=null) {
			valid=true;
			System.out.println("Valid Gender");
		//	return valid;
		}else {
			UnregisteredPropertyException unregisteredPropertyException=
					new UnregisteredPropertyException("Invalid Gender");
			throw unregisteredPropertyException;	
		}
		String mobNo = String.valueOf(mobileNo);
		if (mobNo != null || mobNo.length() == 10 ) {
			valid=true;
			System.out.println("Valid MobileNo");
			return valid;
		}else {
			UnregisteredPropertyException unregisteredPropertyException=
					new UnregisteredPropertyException("Invalid MobileNo");
			throw unregisteredPropertyException;	
		}
		}catch(UnregisteredPropertyException unregisteredPropertyException) {
			System.out.println(unregisteredPropertyException);
		}
		return valid;
	}
	@Override
	public String encodePassword(String pasword) {
		System.out.println("Invoked encodePassword ");
		String encryptedpassword = null;  
        try   
        {  
            /* MessageDigest instance for MD5. */  
            MessageDigest m = MessageDigest.getInstance("MD5");  
            /* Add plain-text password bytes to digest using MD5 update() method. */  
            m.update(pasword.getBytes());  
         
            /* Convert the hash value into bytes */   
            byte[] bytes = m.digest();  
              
            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
              
            /* Complete hashed password in hexadecimal format */  
            encryptedpassword = s.toString();  
        }   
        catch (NoSuchAlgorithmException e)   
        {  
            e.printStackTrace();  
        }           
        /* Display the unencrypted and encrypted passwords. */  
        System.out.println("Plain-text password: " + pasword);  
        System.out.println("Encrypted password using MD5: " + encryptedpassword);      
		return encryptedpassword;
	}

	@Override
	public boolean sendPasswordToEmail(String emailId,String passwordd) {
		System.out.println("Invoked sendPasswordToEmail");
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emailId);
			message.setSubject("Vaccine Registration ");
			message.setText("Vaccine Registration is successful, your password is - " + passwordd);
			mailSender.send(message);
			System.out.println("Simple mailMessage is sent");
			return true;
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return false;
	}
	@Override
	public boolean saveValidRegisterWithEncodedPswdInDB(String userName, String passwordd, String emailId,
			String userDOB,	String userGender, long mobileNo) {
		System.out.println("Invoked saveValidRegisterWithEncodedPswdInDB()");
		try {
			RegisterEntity registerEntity=new RegisterEntity();
			registerEntity.setUserName(userName);
			String hashedPassword = BCrypt.hashpw(passwordd, BCrypt.gensalt());
			
			registerEntity.setPswd(hashedPassword);
			registerEntity.setEmailId(emailId);
			registerEntity.setUserDob(userDOB);
			registerEntity.setGenderR(userGender);
			registerEntity.setMobileNo(mobileNo);
			registerEntity.setLoginCount(0);
			boolean isRegisterEntitySaved=registerRepo.SaveUserRegistrationEntity(registerEntity);
			return isRegisterEntitySaved;
		}catch (Exception exception) {
			System.out.println(exception);
		}
		return false;
	}
}
