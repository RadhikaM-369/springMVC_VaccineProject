package com.xworkz.welcome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.welcome.service.WelcomeServiceImpl;

@Controller
@RequestMapping("/")
public class WelcomeController {
	@Autowired
	private WelcomeServiceImpl welcomeService;
	
	public WelcomeController() {
		System.out.println(this.getClass().getSimpleName()+" bean created");
	}
	@RequestMapping("welcome")
	public String onGetOtpClicked(@RequestParam String email,Model model) {
	System.out.println("invoked onGetOtpClicked ");	
	boolean isEmailValid=welcomeService.validateEmail(email);
	if(isEmailValid) {
		System.out.println("Is email Id Valid : "+isEmailValid);
		
		int isOtp=welcomeService.get4DigitOTP();
		if(isOtp!=0) {
			System.out.println("Is OTP Sent : "+isOtp);		
		boolean isEmailAndOtpSaved=welcomeService.saveEmailAndOTP(email, isOtp);
		if(isEmailAndOtpSaved) {
			System.out.println("Is EmailAndOtp Saved : "+isEmailAndOtpSaved);		
		boolean isMailSent=welcomeService.sendOtpToEmail(email, isOtp);
		if(isMailSent) {
			System.out.println("Is Mail Sent : "+isMailSent);
				return "/WEB-INF/otp.jsp";
		}else { 
			System.out.println("Email not sent..!"+isMailSent);
		}
		}else {
			System.out.println("EmailAndOtp not Saved ..!"+isEmailAndOtpSaved);
		}
		}
		else {
			System.out.println("OTP not Sent : "+isOtp);
		}
		} else {
			System.out.println("Is email Id Valid : "+isEmailValid);
		}	
	return "Welcome.jsp";	
	}
}
