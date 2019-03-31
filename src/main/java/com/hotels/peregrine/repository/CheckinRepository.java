package com.hotels.peregrine.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.command.CheckOutTotalSumCommand;
import com.hotels.peregrine.model.CheckInDTO;

@Repository
public class CheckinRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "checkin";

	//체크인(수속) 메소드~
	public void insert(CheckInDTO check) {
		
		sql.insert("checkin.insert", check);
	}
	
	//체크인한 수속번호 검색
	public Integer select() {
		
		
		return  sql.selectOne("checkin.select");
	}

	//수속번호로 체크아웃(cheOutDate 값 삽입)
	public int checkout(int num) {
		 return sql.update("checkin.checkout",num);
	
	}
	
	//체크아웃한 사람의 결제를 위하여
	public CheckOutTotalSumCommand checkOutOneDTO(int value) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cheNo", value);
		map.put("diAdultPrice",50000);
		map.put("diChildPrice",25000);
		map.put("breAdultPrice",10000);
		map.put("breChildPrice",5000);
		return sql.selectOne("checkin.checkoutAndPayment",map);
	}


	
}
