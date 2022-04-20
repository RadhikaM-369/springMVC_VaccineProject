package com.xworkz.vaccine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VaccineHomeController {
	
	public VaccineHomeController() {
		System.out.println(this.getClass().getSimpleName()+ " bean created");
	}
	
@RequestMapping("vaccineHomepage")
public String onClickAddMember() {
	
	System.out.println("---------------------------------------");
	System.out.println(this.getClass().getSimpleName()+" bean created");
	System.out.println("Invoked onClickAddMember()");
	System.out.println("returning to addMember");
	
	return "/WEB-INF/jspPages/AddMember.jsp";	
}

}
