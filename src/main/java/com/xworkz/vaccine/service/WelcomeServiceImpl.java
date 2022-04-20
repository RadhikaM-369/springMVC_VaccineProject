package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.entity.VaccineEntity;
import com.xworkz.vaccine.exception.InvalidEmailException;
import com.xworkz.vaccine.exception.UnverifiedEmailException;
import com.xworkz.vaccine.repository.WelcomeRepository;

@Service
public class WelcomeServiceImpl implements WelcomeService {
	@Autowired
	private WelcomeRepository welcomeRepo;
	@Autowired
	private MailSender mailSender;

	public WelcomeServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}

	@Override
	public boolean validateEmail(String email) throws InvalidEmailException {
		System.out.println("Invoked validateEmail()");
		try {
			if (!email.isEmpty() && email != null && email.length() > 3 && email.length() < 30 && email.contains("@")
					&& email.endsWith(".com")) {
				System.out.println("Valid email");
				return true;
			} else {
				throw new InvalidEmailException("Invalid email ..!");
			}
		} catch (InvalidEmailException e) {
			System.out.println("InvalidEmailException " + e);
		}
		return false;
	}

	@Override
	public boolean verifyEmailFromDb(String email) {
		boolean temp = false;
		System.out.println("Invoked verifyEmailFromDb()");
		String emailDb = welcomeRepo.getEmailFromDB(email);
		try {
			if (!email.equals(emailDb)) {
				System.out.println("Email is not exist in db, can generate OTP");
				temp = true;
				return temp;
			} else {
				System.out.println("Email already exist in db cannot generate OTP");
				throw new UnverifiedEmailException("Email already exist in db cannot generate OTP");
			}
		} catch (UnverifiedEmailException unverifiedEmailException) {
			System.out.println(unverifiedEmailException);
		}
		return temp;
	}

	@Override
	public boolean saveEmailAndOTP(String email, int otp) {
		System.out.println("Invoked saveEmail()");
		try {
			VaccineEntity welcomeEntity = new VaccineEntity();
			welcomeEntity.setEmail(email);
			welcomeEntity.setOtp(otp);
			boolean isEntitySaved = welcomeRepo.saveWelcomeEntity(welcomeEntity);
			return isEntitySaved;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public int getFourDigitOTP() {
		System.out.println("Invoked get4DigitOTP()");
		try {
			int randomOtp = (int) (Math.random() * 9000) + 1000;
			System.out.println("OTP : " + randomOtp);
			return randomOtp;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public boolean sendOtpToEmail(String email, int otp) {
		System.out.println("Invoked sendOtpToEmail");
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);
			message.setSubject(" Vaccine OTP ");
			message.setText("Vaccine OTP- " + otp + " recieved successfully.. ");
			mailSender.send(message);
			System.out.println("Simple mailMessage is sent");
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
