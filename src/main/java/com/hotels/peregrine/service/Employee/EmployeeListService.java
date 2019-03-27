package com.hotels.peregrine.service.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.EmployeeDTO;
import com.hotels.peregrine.repository.EmployeeRepository;

@Service
public class EmployeeListService {

	@Autowired
	EmployeeRepository repository;
	
	public List<EmployeeDTO> action() {


		return repository.memberList();
		
	}

}
