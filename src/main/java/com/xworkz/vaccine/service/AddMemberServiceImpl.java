package com.xworkz.vaccine.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xworkz.vaccine.controller.WelcomeController;
import com.xworkz.vaccine.dto.AddMemberDto;
import com.xworkz.vaccine.entity.AddMemberEntity;
import com.xworkz.vaccine.exception.InvalidDoseException;
import com.xworkz.vaccine.exception.InvalidGenderException;
import com.xworkz.vaccine.exception.InvalidIdNumberException;
import com.xworkz.vaccine.exception.InvalidIdProofException;
import com.xworkz.vaccine.exception.InvalidNameException;
import com.xworkz.vaccine.exception.InvalidVaccineTypeException;
import com.xworkz.vaccine.exception.InvalidYOBException;
import com.xworkz.vaccine.repository.AddMemberRepositoryImpl;
import com.xworkz.vaccine.repository.WelcomerRepositoryImpl;

@Service
public class AddMemberServiceImpl implements AddMemberService {
	@Autowired
	private AddMemberRepositoryImpl addMemberRepo;
	@Autowired
	private WelcomerRepositoryImpl welcomeRepo;

	@Override
	public boolean validateAddMemberDto(AddMemberDto addMemberDto) throws InvalidNameException {
		System.out.println("Invoked validateAddMemberDto()");
		boolean temp = false;
		if (addMemberDto.getName() != null && !addMemberDto.getName().isEmpty() && addMemberDto.getName().length() > 3
				&& addMemberDto.getName().length() < 50) {
			temp = true;
			System.out.println("Valid Name");
		} else {
			InvalidNameException invalidNameException = new InvalidNameException("Invalid Name");
			throw invalidNameException;
		}
		if (addMemberDto.getYob() != null && !addMemberDto.getYob().isEmpty() && addMemberDto.getYob().length() == 4) {
			temp = true;
			System.out.println("Valid Year Of Birth");
		} else {
			InvalidYOBException invalidYOBException = new InvalidYOBException("Invalid invalidYOBException");
			throw invalidYOBException;
		}
		if (addMemberDto.getVaccineType() != null && !addMemberDto.getVaccineType().isEmpty()) {
			temp = true;
			System.out.println("Valid vaccine type");
		} else {
			InvalidVaccineTypeException invalidVaccineTypeException = new InvalidVaccineTypeException(
					"Invalid vaccine type");
			throw invalidVaccineTypeException;
		}
		if (addMemberDto.getIdNumber() != null && !addMemberDto.getIdNumber().isEmpty()) {
			temp = true;
			System.out.println("valid Id number");
		} else {
			InvalidIdNumberException invalidIdNumberException = new InvalidIdNumberException("Invalid IdNumber");
			throw invalidIdNumberException;
		}
		if (addMemberDto.getIdProof() != null && !addMemberDto.getIdProof().isEmpty()) {
			temp = true;
			System.out.println("valid Id proof");
		} else {
			InvalidIdProofException invalidIdProofException = new InvalidIdProofException("invalid Id proof");
			throw invalidIdProofException;
		}
		if (addMemberDto.getDose() != null && !addMemberDto.getDose().isEmpty()) {
			temp = true;
			System.out.println("Valid Dose");
		} else {
			InvalidDoseException invalidDoseException = new InvalidDoseException("Invalid Dose");
			throw invalidDoseException;
		}
		if (addMemberDto.getGender() != null && !addMemberDto.getGender().isEmpty()) {
			temp = true;
			System.out.println("Valid Gender");
			
		} else {
			InvalidGenderException invalidGenderException = new InvalidGenderException("Invalid Gender");
			throw invalidGenderException;
		}
		return temp;
	}

	@Override
	public boolean saveAddMemberDto(AddMemberDto addMemberDto) {
		System.out.println("Invoked saveAddMemberDto");
		try {
			AddMemberEntity addMemberEntity = new AddMemberEntity();
			BeanUtils.copyProperties(addMemberDto, addMemberEntity);
			//VaccineEntity vaccineEntity =new VaccineEntity();
			int memberCount1=welcomeRepo.getMemberCountFromDB(WelcomeController.email);
			System.out.println(" Membercount from getMemberCountFromDB- "+memberCount1);
			if(memberCount1>=4) {
				System.out.println("Cannot add more than 4 members");
				return false;
			}else {			
			boolean isEntitySaved = addMemberRepo.saveAddMemberEntity(addMemberEntity);
			memberCount1++;
			welcomeRepo.updateMemberCount(WelcomeController.email,memberCount1);
			isEntitySaved=true;
			return isEntitySaved;
			}
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return false;
	}
	@Override
	public List<Object> getAllMemberData() {
		System.out.println("Invoked getAllMemberData");
		List<Object> addMembers=null;
		try {
		List<AddMemberEntity> addMemberEntity=this.addMemberRepo.getAllMemberDataFromDB();
		if(addMemberEntity!=null) {
			return addMembers=new ArrayList<Object>(addMemberEntity);
		}
		//return addMembers;
		}
		catch(Exception exception) {
		System.out.println(exception);
		}
		return addMembers;
}
}
