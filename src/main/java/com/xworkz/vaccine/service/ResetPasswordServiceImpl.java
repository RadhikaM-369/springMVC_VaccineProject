package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.xworkz.vaccine.entity.RegisterEntity;
import com.xworkz.vaccine.exception.UnregisteredPropertyException;
import com.xworkz.vaccine.repository.ResetPasswordRepositoryImpl;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService{
	@Autowired
	private ResetPasswordRepositoryImpl resetPasswordRepo;
	@Autowired
	private MailSender mailSender;	
	
	
	@Override
	public boolean validateResetPasswordInfo(String emailId, String newPassword, String confirmPassword) {
	boolean valid=false;
	try {
		if(emailId!=null || !emailId.isEmpty() || emailId.length()>3 || emailId.length()<50||
				emailId.contains("@")||emailId.endsWith(".com")) {
			valid=true;
			System.out.println("Valid emailId");
		}else {
			UnregisteredPropertyException unregisteredPropertyException=
					new UnregisteredPropertyException("Invalid emailId");
			throw unregisteredPropertyException;	
		}
		if(newPassword!=null || !newPassword.isEmpty() || newPassword.length()>3|| newPassword.length()<20) {
			valid=true;
			System.out.println("valid newpassword");
		}else {
			UnregisteredPropertyException unregisteredPropertyException=
					new UnregisteredPropertyException("Invalid newPassword");
			throw unregisteredPropertyException;	
		}
		if(confirmPassword!=null || !confirmPassword.isEmpty() || confirmPassword.length()>3|| confirmPassword.length()<20) {
			valid=true;
			System.out.println("valid confirmPassword");
		}else {
			UnregisteredPropertyException unregisteredPropertyException=
					new UnregisteredPropertyException("Invalid confirmPassword");
			throw unregisteredPropertyException;	
		}
	}catch(UnregisteredPropertyException unregisteredPropertyException) {
		System.out.println(unregisteredPropertyException);
	}
		return valid;		
	}

	@Override
	public boolean matchNewAndConfirmPassword(String newPassword, String confirmPassword) {
		System.out.println("Invoked matchNewAndConfirmPassword");
		boolean isPasswordMatch=newPassword.equals(confirmPassword);
		if(isPasswordMatch) {
			System.out.println("is newPassword equals confirmPassword- "+isPasswordMatch);
			return isPasswordMatch;
		}else {
			System.out.println("newPassword "+newPassword+"is not equals to- "+confirmPassword);
			System.out.println("is newPassword equals confirmPassword- "+isPasswordMatch);
		}
		return false;
	}

	@Override
	public String encodeConfirmPassword( String confirmPassword) {
		System.out.println("Invoked encodeConfirmPassword");
		String encryptedConfirmPassword = BCrypt.hashpw(confirmPassword, BCrypt.gensalt());
		System.out.println("encryptedConfirmPassword is- "+encryptedConfirmPassword);
		return encryptedConfirmPassword;
	}

	@Override
	public boolean updateEncodedConfirmPasswordByEmail(String ConfirmPassword, String email) {
		System.out.println("Invoked updateEncodedConfirmPasswordByEmail");
		try {
		  boolean isUpdateConfirmPassword = resetPasswordRepo.updateConfirmPasswordByEmailID(ConfirmPassword, email);
		 
		  return isUpdateConfirmPassword;
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return false;
	}

	@Override
	public boolean sendResetPasswordToEmail(String confirmPassword, String email) {
		System.out.println("INVOKED sendResetPasswordToEmail");
		 try {
				SimpleMailMessage message = new SimpleMailMessage();
				message.setTo(email);
				message.setSubject(" Reset Password ");
				message.setText("Your new password is - " + confirmPassword + " recieved successfully.. ");
				mailSender.send(message);
				System.out.println("new password is sent");
				return true;
			} catch (Exception exception) {
				System.out.println(exception);
			}
		return false;
	}

}
