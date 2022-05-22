package com.xworkz.vaccine.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.WelcomeServiceImpl;

@Controller
@RequestMapping("/")
public class WelcomeController {
	public static String email;
	@Autowired
	private WelcomeServiceImpl welcomeService;

	public WelcomeController() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}
		
	@RequestMapping("/register")
	public String onClickReisterLink() {
		System.out.println("Invoked onClickReisterLink");
		return "/WEB-INF/jspPages/Register.jsp";		
	}
	
	@RequestMapping("/welcome")
	public String onGetOtpClicked( HttpServletRequest request, HttpServletRequest response,
		@RequestParam String email, Model model) {
		System.out.println("invoked onGetOtpClicked ");
		
		HttpSession session=request.getSession();
		session.setAttribute("email",email);
		
		WelcomeController.email=email;
		boolean isEmailValid = welcomeService.validateEmail(email);
		if (isEmailValid) {
			System.out.println(" Email Id Validation : " + isEmailValid);
			boolean isEmailVerified = welcomeService.verifyEmailFromDb(email);

			if (isEmailVerified) {
				System.out.println("Email verification : " + isEmailVerified);

				int isOtp = welcomeService.getFourDigitOTP();
				if (isOtp != 0) {
					System.out.println("Generated OTP is : " + isOtp);

					boolean isEmailAndOtpSaved = welcomeService.saveEmailAndOTP(email, isOtp);
					if (isEmailAndOtpSaved) {
						System.out.println("EmailAndOtp Saved in DB : " + isEmailAndOtpSaved);

						boolean isMailSent = welcomeService.sendOtpToEmail(email, isOtp);
						if (isMailSent) {
							model.addAttribute("msg", "Email sent to id. - " + email);
							System.out.println("Mail Sent : " + isMailSent);
							return "/WEB-INF/jspPages/Otp.jsp";
						} else {
							model.addAttribute("msg", "Email not sent. - " + email);
							System.out.println("Email not sent..!" + isMailSent);
						}
					} else {
						model.addAttribute("msg", "EmailAndOtp not Saved ..!" + email + isOtp);
						System.out.println("EmailAndOtp not Saved ..!" + email + isOtp);
					}
				} else {
					model.addAttribute("msg", "OTP not generated" + isOtp);
					System.out.println("OTP not generated : " + isOtp);
				}
			} else {
				System.out.println("cannot verify Email ");
				model.addAttribute("msg", "cannot verify Email");
			}
		} else {
			System.out.println("cannot validate email");
			model.addAttribute("msg", "cannot validate Email");
		}
		return "Welcome.jsp";
	}
}


