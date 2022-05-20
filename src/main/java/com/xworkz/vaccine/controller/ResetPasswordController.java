package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.repository.ResetPasswordRepositoryImpl;
import com.xworkz.vaccine.service.ResetPasswordServiceImpl;

@Controller
@RequestMapping("/")
public class ResetPasswordController {
	@Autowired
	private ResetPasswordServiceImpl resetPasswordService;

	public ResetPasswordController() {
		System.out.println(this.getClass().getSimpleName() + "Bean created");
	}

	@RequestMapping("/reset")
	public String onClickReset(@RequestParam String email, @RequestParam String newPassword,
			@RequestParam String confirmPassword, Model model) {
		System.out.println("Invoked onClickReset");

		boolean isValidResetInfo = resetPasswordService.validateResetPasswordInfo(email, newPassword, confirmPassword);
		if (isValidResetInfo) {
			System.out.println("isValidResetInfo - " + isValidResetInfo);
			System.out.println("Reset Info is valid");
			boolean isPasswordMatch = resetPasswordService.matchNewAndConfirmPassword(newPassword, confirmPassword);
			if (isPasswordMatch) {
				System.out.println("is new password Match with confirmpassword - " + isValidResetInfo);
				System.out.println("new password Match with confirmpassword ");
				boolean isResetPasswordSentToEmail = resetPasswordService.sendResetPasswordToEmail(confirmPassword,
						email);
				if (isResetPasswordSentToEmail) {
					System.out.println("is ResetPassword Sent To Email - " + isResetPasswordSentToEmail);
					System.out.println("ResetPassword Sent To Email ");
					String encryptConfirmPassword = resetPasswordService.encodeConfirmPassword(confirmPassword);
					if (encryptConfirmPassword != null) {
						boolean updateNewPassword = resetPasswordService
								.updateEncodedConfirmPasswordByEmail(encryptConfirmPassword, email);
						if (updateNewPassword) {
							System.out.println("Encrypted Password- " + encryptConfirmPassword + " is updated in DB");
							System.out.println("UpdateNewPassword in db - " + updateNewPassword);
							return "/WEB-INF/jspPages/Login.jsp";
						} else {
							System.out.println("UpdateNewPassword in db - " + updateNewPassword);
							model.addAttribute("confirmPassword", "cannot update password");
						}
					} else {
						System.out.println("Password is not encrypted");
					}
				} else {
					System.out.println("ResetPassword not Sent To Email");
				}
			} else {
				System.out.println("new password is not Matching with confirmpassword ");
				model.addAttribute("confirmpassword", "confirmpassword is not Matching with New password");
			}
		} else {
			System.out.println("Reset information is not valid");
		}
		return "/WEB-INF/jspPages/ResetPassword.jsp";
	}
}
