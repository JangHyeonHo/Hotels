package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.command.LoginCommand;
import com.hotels.peregrine.model.EmployeeDTO;

@Repository
public class EmployeeRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void Einser(EmployeeDTO dto) {
		
		sql.insert("employee.einsert",dto);
		
	}

	public List<EmployeeDTO> memberList() {
		
		return sql.selectList("employee.mlist");
	}

	public EmployeeDTO thisMemberisExist(LoginCommand command) {
		// TODO Auto-generated method stub
		return sql.selectOne("employee.member",command);
	}
	
}
