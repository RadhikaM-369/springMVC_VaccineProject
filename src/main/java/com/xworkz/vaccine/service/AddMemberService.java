package com.xworkz.vaccine.service;

import com.xworkz.vaccine.dto.AddMemberDto;

public interface AddMemberService {
public boolean validateAddMemberDto(AddMemberDto addMemberDto );
boolean saveAddMemberDto(AddMemberDto addMemberDto);
}
