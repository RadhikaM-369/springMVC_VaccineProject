package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.RegisterUserServiceImpl;

@Controller
@RequestMapping("/")
public class RegisterController {
	@Autowired
	private RegisterUserServiceImpl registerUserService;
	
	public RegisterController() {
		System.out.println(this.getClass().getSimpleName()+" Bean created");
	}
	
	@RequestMapping("/getLoginPage")
	public String getLoginPage() {
		
		return "/WEB-INF/jspPages/Login.jsp";
	}
	
	@RequestMapping("/registerPage")
	public String onClickRegister(@RequestParam String userName,@RequestParam String pswd,@RequestParam String emailId,
			@RequestParam String genderR, @RequestParam long mobileNo,@RequestParam String userDob,Model model){
		System.out.println("Invoked onClickRegister");		
	
		boolean isRegisterDtoValid=registerUserService.validateRegisterDto(userName, pswd, emailId, userDob, genderR, mobileNo);
		if(isRegisterDtoValid) {
		System.out.println("isRegisterDtoValid - "+isRegisterDtoValid);
		
		boolean isEmailSent=registerUserService.sendPasswordToEmail(emailId,pswd);
		if(isEmailSent) {
		System.out.println("isEmailSent - "+ isEmailSent);
		model.addAttribute("mailSent", "Email sent");
		System.out.println("password - "+pswd+" is sent to emailID- "+emailId);
		
		boolean isRegisterDataSaved=registerUserService.saveValidRegisterWithEncodedPswdInDB(userName, pswd, emailId, userDob, genderR, mobileNo);
		if(isRegisterDataSaved) {
		model.addAttribute("regStatus", "Data is saved to register DB");
		System.out.println("isRegisterDataSaved - "+isRegisterDataSaved);	
		System.out.println("Data is saved to register DB");		
		}else {
			model.addAttribute("regStatus", "Data is not saved to register DB");
			System.out.println("isRegisterDataSaved - "+isRegisterDataSaved);
			System.out.println("Data is not saved to register DB");
		}}else{
			model.addAttribute("mailSent", "Data is not saved to register DB");
			System.out.println("isRegisterDataSaved - "+isEmailSent);
			System.out.println("Password is not sent to emailID");
		}}
		else {
			model.addAttribute("regStatus", "Data is not Validated");
			System.out.println("isRegisterDtoValid - "+isRegisterDtoValid);
			System.out.println("Data is not Validated");	
		}		
		return "/WEB-INF/jspPages/Login.jsp";
	}

}
