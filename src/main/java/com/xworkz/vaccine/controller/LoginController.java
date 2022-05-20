package com.xworkz.vaccine.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.AddMemberServiceImpl;
import com.xworkz.vaccine.service.LoginServiceImpl;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private AddMemberServiceImpl addMemberService;
	
	public LoginController() {
		System.out.println(this.getClass().getSimpleName()+" bean created");
	}
	@RequestMapping("/resetPassword")
	public String onClickResetPassword() {
		
		return "/WEB-INF/jspPages/ResetPassword.jsp";
	}
	
	@RequestMapping("/getLoginPage")
	public String getLoginPage() {
		
		return "/WEB-INF/jspPages/Login.jsp";
	}
	
	@RequestMapping("/login")
	public String onClickLogin(@RequestParam String userName,@RequestParam String pswd,Model model) {
		boolean isValidateLogin = loginService.validateLoginInfo(userName, pswd);

		if (isValidateLogin) {
			System.out.println("Login Information is valid :" + isValidateLogin);
			boolean isCredentialUser = loginService.decodePasswordAndCompare(pswd, userName);
			if (isCredentialUser) {
				model.addAttribute("CredentialStatus", "User Credential  is Matching successfully !");
				System.out.println("User Credential  is Matching successfully !" + isCredentialUser);
				
				List<Object> allMembers=addMemberService.getAllMemberData();
				model.addAttribute("ListOfAllMembers", allMembers);
				
				return "/WEB-INF/jspPages/VaccineHomePage.jsp";
			} else {
				int isBlockUser=loginService.blockUser(pswd, userName);		
				if(isBlockUser>=3) {
					System.out.println("isBlockUser - "+isBlockUser);
					model.addAttribute("blockuserStatus", "exceeded max login attempt");
					return "/WEB-INF/jspPages/Login.jsp";
				}
				model.addAttribute("CredentialStatus", "Bad Credential !Try again  ");
				System.out.println("Verification of Credential is  not matching  !" + isCredentialUser);
				return "/WEB-INF/jspPages/Login.jsp";
			}			
		} else {
			model.addAttribute("CredentialStatus", "Invalidate User credentials");
			System.out.println("Verification of Credential not done !" + isValidateLogin);
		}
		return "/WEB-INF/jspPages/Login.jsp";
	}
		
}

