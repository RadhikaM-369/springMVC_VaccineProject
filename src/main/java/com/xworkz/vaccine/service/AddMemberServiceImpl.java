package com.xworkz.vaccine.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

@Service
public class AddMemberServiceImpl implements AddMemberService {
	@Autowired
	private AddMemberRepositoryImpl addMemberRepo;

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
			boolean isEntitySaved = addMemberRepo.saveAddMemberEntity(addMemberEntity);
			return isEntitySaved;
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return false;
	}
}
