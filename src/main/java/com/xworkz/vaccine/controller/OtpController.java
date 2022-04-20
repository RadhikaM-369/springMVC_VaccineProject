package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.OtpServiceImpl;

@Controller
@RequestMapping("/")
public class OtpController {
	@Autowired
	private OtpServiceImpl otpService;

	public OtpController() {
		System.out.println(this.getClass().getSimpleName() + " bean invoked");
	}

	@RequestMapping("/otp")
	public String onClickedVerifyButton(@RequestParam int otp, Model model) {
		System.out.println("----------------------------------------------");
		System.out.println("Invoked onClickedVerifyButton");
		boolean isValidOtp = otpService.validateOTP(otp);
		if (isValidOtp) {
			System.out.println("OTP Is Valid" + otp);

			boolean isOtpVerified = otpService.verifyOtpFromDb(otp);
			if (isOtpVerified) {
				System.out.println("verifiedOTP is matched uiOTP");
				//model.addAttribute("verifiedOTPmsg", "OTP is verified..!");
				return "/WEB-INF/jspPages/VaccineHomePage.jsp";
			} else {
				System.out.println("verifiedOTP is not matching with uiOTP");
				model.addAttribute("verifiedOTPmsg", "OTP is not varified or not matching");
				return "/WEB-INF/jspPages/Otp.jsp";
			}
		} else {
			System.out.println("OTP Is inValid" + otp);
			model.addAttribute("validOTPmsg", "OTP - " + otp + " is inValid");
		}
		return "/WEB-INF/jspPages/Otp.jsp";
	}
}

//int verifiedOtpInt=((Integer) verifiedOtp).intValue();
