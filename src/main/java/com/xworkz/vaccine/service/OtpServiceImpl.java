package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xworkz.vaccine.exception.InvalidOtpException;
import com.xworkz.vaccine.exception.UnverifiedOtpException;
import com.xworkz.vaccine.repository.OtpRepository;

@Service
public class OtpServiceImpl implements OtpService {
	@Autowired
	private OtpRepository otpRepo;

	public OtpServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}

	@Override
	public boolean validateOTP(int otp) {
		System.out.println("Invoked validateEmail()");
		try {
			String otpInString=String.valueOf(otp);
			if (otpInString!=null && !otpInString.isEmpty() && otpInString.length()==4) {
				System.out.println("Valid otp");
				return true;
			} else {
				throw new InvalidOtpException("Invalid OTP ..!");
			}
		} catch (InvalidOtpException exception) {
			System.out.println("Invalid Otp Exception" + exception);
		}
		return false;
	}

	@Override
	public boolean verifyOtpFromDb(int otp) {
		boolean temp=false;
		System.out.println("Invoked verifyOtpFromDb()");
		try{
		int vaccineOtpFromDb1=otpRepo.getOtpFromTable(otp);
		if(otp==vaccineOtpFromDb1) {
			System.out.println("OTP verified");
		temp=true;	
		return temp;
		}else {
			throw new UnverifiedOtpException("OTP not verified");
		}}catch(UnverifiedOtpException unverifiedOtpException) {
			System.out.println(unverifiedOtpException);
		}
		return temp;
		}
}

	
	/*if(vaccineOtpFromDb1!=0) {
	System.out.println("Got Otp from getOtpFromTableByEmail-"+vaccineOtpFromDb1);		
	try {
		if(otp==vaccineOtpFromDb1) {
		System.out.println("Otp : "+otp+" is verified & matching with otp in DB "+vaccineOtpFromDb1);
		temp=true;
		return temp;
	}else {
		throw new UnverifiedOtpException("Otp is not verified & matching with otp in DB");
	}		
	} catch(UnverifiedOtpException e) {
		System.out.println("Otp is not verified & matching with otp in DB "+e);
	}
	}else {
		throw new UnverifiedOtpException("OTP IS NOT FOUND");
	}
	}catch(UnverifiedOtpException e) {
		System.out.println("OTP IS NOT FOUND...!  "+e);
	}*/
