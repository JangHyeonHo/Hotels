package com.hotels.peregrine.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.command.LoginCommand;
import com.hotels.peregrine.model.EmployeeDTO;
import com.hotels.peregrine.repository.EmployeeRepository;

@Service
public class SearchAMemberService {
	
	@Autowired
	private EmployeeRepository repository;

	public EmployeeDTO isExist(LoginCommand command) {
		// TODO Auto-generated method stub
		return repository.thisMemberisExist(command);
	}

}
