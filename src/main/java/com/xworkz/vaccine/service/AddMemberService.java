package com.xworkz.vaccine.service;

import java.util.List;

import com.xworkz.vaccine.dto.AddMemberDto;

public interface AddMemberService {
public boolean validateAddMemberDto(AddMemberDto addMemberDto );
boolean saveAddMemberDto(AddMemberDto addMemberDto);
public List<Object> getAllMemberData();
}
