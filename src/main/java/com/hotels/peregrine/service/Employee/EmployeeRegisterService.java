package com.hotels.peregrine.service.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.EmployeeDTO;
import com.hotels.peregrine.repository.EmployeeRepository;

@Service
public class EmployeeRegisterService {

	@Autowired
	EmployeeRepository repository;
	
	public void action(EmployeeDTO dto) {
		
		repository.Einser(dto);
		
	}
}
