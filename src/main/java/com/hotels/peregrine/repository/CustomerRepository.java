package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.model.RoomDTO;

@Repository
public class CustomerRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "custom";

	public void insert(CustomerDTO customers) {
		sql.insert("custom.insert",customers);
		
	}

	public Integer select(CustomerDTO customers) {

		
		return sql.selectOne("custom.select",customers);
	}

	

}
