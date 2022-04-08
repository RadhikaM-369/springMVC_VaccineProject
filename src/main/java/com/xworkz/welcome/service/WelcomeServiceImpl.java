package com.xworkz.welcome.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import com.xworkz.welcome.entity.WelcomeEntity;
import com.xworkz.welcome.exception.InvalidEmailException;
import com.xworkz.welcome.repository.WelcomeRepository;

@Service
public class WelcomeServiceImpl implements WelcomeService{
	@Autowired
	private WelcomeRepository welcomeRepo;
	@Autowired
	private MailSender mailSender;
	
	public WelcomeServiceImpl() {
		System.out.println(this.getClass().getSimpleName()+" bean created");
	}

	@SuppressWarnings("unused")
	@Override
	public boolean validateEmail(String email) throws InvalidEmailException {
		boolean valid=false;
		System.out.println("Invoked validateEmail()");
		if(!email.isEmpty() || email!=null || email.length()>3 || email.length()<30 || 
			email.contains("@")|| email.endsWith(".com")) {
			valid=true;
			System.out.println("Valid email");
		} else {
			InvalidEmailException invalidEmail=new InvalidEmailException("Invalid email ..!");
			throw invalidEmail;
		}
		return valid;
	}

	@Override
	public boolean saveEmailAndOTP(String email,int otp) {
		System.out.println("Invoked saveEmail()");
		WelcomeEntity welcomeEntity=new WelcomeEntity();
		welcomeEntity.setEmail(email);
		welcomeEntity.setOtp(otp);
		boolean isEntitySaved=welcomeRepo.saveWelcomeEntity(welcomeEntity);
		return isEntitySaved;		
	}

	@Override
	public int get4DigitOTP() {
		System.out.println("Invoked get4DigitOTP()");
		int randomOtp =(int) (Math.random()*9000)+1000;
		System.out.println("OTP : "+randomOtp);
		return randomOtp;
	}

	@Override
	public boolean sendOtpToEmail(String email, int otp) {
		System.out.println("Invoked sendOtpToEmail");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Task2-OTP ");
		message.setText("Sending OTP- "+otp);
		mailSender.send(message);
		System.out.println("Simple mailMessage is sent");
		return true;
	}
}
