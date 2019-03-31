package com.hotels.peregrine.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.OrdersDTO;
import com.hotels.peregrine.model.RestaurantReservationDTO;

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
	public int firstOrder(int table, int i) {
		// TODO Auto-generated method stub
		OrdersDTO dto = new OrdersDTO().setOrdTableNum(table).setRestaurantReservation(new RestaurantReservationDTO().setRrNo(i));
		return template.insert(namespace+".firstOrder", dto);
	}

	public List<OrdersDTO> amountCall() {
		// TODO Auto-generated method stub
		return template.selectList(namespace+".fullamount");
	}

	public int allPriceSet(int table, int price) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("tableNum", table);
		map.put("price", price);
		return template.update(namespace+".sumPrice",map);
	}

	public int updatePayNo(int tableNum, int payNo) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("tableNum", tableNum);
		map.put("payNo", payNo);
		return template.update(namespace + ".updatePayNo", map);
	}

	public int noPersonDeleteAll() {
		// TODO Auto-generated method stub
		return template.delete(namespace+".deleteNoPerson");
	}

	
	
	
	
}
