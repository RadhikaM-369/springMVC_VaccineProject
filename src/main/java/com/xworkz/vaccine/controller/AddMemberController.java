package com.xworkz.vaccine.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xworkz.vaccine.dto.AddMemberDto;
import com.xworkz.vaccine.service.AddMemberServiceImpl;

@Controller
@RequestMapping("/")
public class AddMemberController {
	@Autowired
	private AddMemberServiceImpl addMemberService;

	public AddMemberController() {
		System.out.println(this.getClass().getSimpleName()+" Bean created..");
	}
	@RequestMapping("addMember")
	public String onClickAddMemberToDB(@ModelAttribute AddMemberDto dto,Model model) {
		System.out.println("Invoked onClickAddMemberToDB");
		boolean result= addMemberService.validateAddMemberDto(dto);
		if(result) {
			model.addAttribute("msg", "Member Data Saved");
			System.out.println("Member Validation : "+result);
			boolean isDataSaved=addMemberService.saveAddMemberDto(dto);
			if(isDataSaved) {
				System.out.println("Member Data Saved");
				List<Object> allMembers=this.addMemberService.getAllMemberData();
				if(allMembers!=null) {
				model.addAttribute("ListOfAllMembers", allMembers);
				return "/WEB-INF/jspPages/VaccineHomePage.jsp";
			}else {
				System.out.println("Can not display all members");
				return "/WEB-INF/jspPages/VaccineHomePage.jsp";
		}}	else {
			model.addAttribute("msg", "Member Data not Saved");	
			model.addAttribute("countValue", "Can not add more than 4 members");
		}} else {
			model.addAttribute("msg","Invalid data or input");
		}System.out.println(dto);
		return "/WEB-INF/jspPages/AddMember.jsp";	
	}
}
/*
@RequestMapping("/displayAll")
	public String displayAllGroceryItems(Model model) {
		System.out.println("Invoked displayAllGroceryItems()");

		List<Object> allLaptopInfo = this.laptopService.displayAll();
		model.addAttribute("ListOfLaptops", allLaptopInfo);
		return "/LaptopInfo.jsp";
*/