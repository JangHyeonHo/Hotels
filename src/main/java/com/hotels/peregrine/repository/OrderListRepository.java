package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.OrderListDTO;

@Repository
public class OrderListRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "orderlist";

	//주문한 테이블의 리스트 상세정보
	public List<OrderListDTO> tableInfomation(int table) {
		// TODO Auto-generated method stub
		return template.selectList(namespace+".tableCall", table);

	}

	public int listInsert(OrderListDTO ol) {
		// TODO Auto-generated method stub
		return template.insert(namespace + ".olRegist", ol);
	}

	public int listUpdate(OrderListDTO ol) {
		// TODO Auto-generated method stub
		return template.update(namespace + ".olUpdate", ol);
	}

	public int listDelete(OrderListDTO ol) {
		// TODO Auto-generated method stub
		return template.delete(namespace + ".olDelete", ol);
	}
	
}
