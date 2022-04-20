package com.xworkz.vaccine.repository;

import com.xworkz.vaccine.entity.AddMemberEntity;
import com.xworkz.vaccine.exception.InvalidNameException;

public interface AddMemberRepository {
public boolean saveAddMemberEntity(AddMemberEntity addMemberEntity)throws InvalidNameException;
}
