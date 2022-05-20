package com.xworkz.vaccine.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.service.AddMemberService;

@Controller
@RequestMapping("/")
public class VaccineHomeController {
	@Autowired
	private AddMemberService addMemberService;
	public VaccineHomeController() {
		System.out.println(this.getClass().getSimpleName()+ " bean created");
	}	
@RequestMapping("/vaccineHomepage")
public String onClickAddMember( Model model) {	
	System.out.println("---------------------------------------");
	System.out.println(this.getClass().getSimpleName()+" bean created");
	System.out.println("Invoked onClickAddMember()");
	System.out.println("returning to addMember");
	model.addAttribute("countValue", "Can not add more than 4 members");	
	return "/WEB-INF/jspPages/AddMember.jsp";	
}
@RequestMapping("/getAllAddMembers")
public String getAllAddMembers(Model model) {
	List<Object> allMembers=addMemberService.getAllMemberData();
	if(allMembers!=null) {
	model.addAttribute("ListOfAllMembers", allMembers);
	return "/WEB-INF/jspPages/VaccineHomePage.jsp";
}else {
	System.out.println("Can not display all members");
	return "/WEB-INF/jspPages/VaccineHomePage.jsp";
}
}
}
