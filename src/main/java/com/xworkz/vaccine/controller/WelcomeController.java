package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.WelcomeServiceImpl;

@Controller
@RequestMapping("/")
public class WelcomeController {
	@Autowired
	private WelcomeServiceImpl welcomeService;
	
	public WelcomeController() {
		System.out.println(this.getClass().getSimpleName()+" bean created");
	}
	@RequestMapping("welcome")
	public String onGetOtpClicked(@RequestParam String email, Model model) {
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
			model.addAttribute("msg","Email sent to id. - "+email);
			System.out.println("Is Mail Sent : "+isMailSent);
				return "/WEB-INF/files/otp.jsp";
		}else { 
			model.addAttribute("msg","Email not sent. - "+email);
			System.out.println("Email not sent..!"+isMailSent);
		}
		}else {
			model.addAttribute("msg","EmailAndOtp not Saved ..!"+email+isOtp);
			System.out.println("EmailAndOtp not Saved ..!"+email+isOtp);
		}
		}
		else {
			model.addAttribute("msg","OTP not Sent"+isOtp);
			System.out.println("OTP not Sent : "+isOtp);
		}
		} else {
			model.addAttribute("msg","invalid email id.."+email);
			System.out.println("invalid email id : "+email);
		}	
	return "Welcome.jsp";	
	}
	
}
