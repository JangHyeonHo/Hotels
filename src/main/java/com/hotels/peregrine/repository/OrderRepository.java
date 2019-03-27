package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.OrdersDTO;

@Repository
public class OrderRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "orders";

	//해당 테이블의 주문여부
	public boolean isRegist(int table) {
		// TODO Auto-generated method stub
		//테이블이 존재하지 않는다면
		if(template.selectOne(namespace + ".isRegist", table)==null) {
			//결제가 된 테이블만 존재하고 실제 아직 주문이 없을 경우
			System.out.println("해당 테이블은 등록이 되어있지 않음");
			return false;
		}
		return true;
	}
	
	//테이블에 주문된 이력이 없어서 바로 주문을 하였을 떄
	public int firstOrder(int table) {
		// TODO Auto-generated method stub
		return template.insert(namespace+".firstOrder", table);
	}

	public List<OrdersDTO> amountCall() {
		// TODO Auto-generated method stub
		return template.selectList(namespace+".fullamount");
	}

	
	
	
	
}
