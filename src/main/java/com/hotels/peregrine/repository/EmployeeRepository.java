package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.EmployeeDTO;

@Repository
public class EmployeeRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void Einser(EmployeeDTO dto) {
		
		sql.insert("employee.einsert",dto);
		
	}
	
}
