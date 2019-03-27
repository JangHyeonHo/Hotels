package com.hotels.peregrine.service.fb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.OrderListDTO;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.repository.OrderListRepository;
import com.hotels.peregrine.repository.OrderRepository;

@Service
public class OrderRegistService {
	
	@Autowired
	private OrderRepository order;
	
	@Autowired
	private OrderListRepository orderlist;

	public boolean isRegist(int table) {
		// TODO Auto-generated method stub
		return order.isRegist(table);
	}

	public int firstOrderCall(int table) {
		// TODO Auto-generated method stub
		return order.firstOrder(table);
	}

	public List<OrderListDTO> orderInfo(int table) {
		// TODO Auto-generated method stub
		return orderlist.tableInfomation(table);
	}

	public int orderRegist(List<OrderListDTO> olList) {
		// TODO Auto-generated method stub
		List<OrderListDTO> tableCall = orderlist.tableInfomation(olList.get(0).getOrders().getOrdTableNum());
		int insertResult = 0;
		int updateResult = 0;
		int deleteResult = 0;
		for(int i = 0; i < olList.size(); i++) {
			AutoTest.ModelBlackTest(olList.get(i));
			String oldList = null;
			if(tableCall.size() > i) {
				oldList = tableCall.get(i).getFood().getFoodName();
			}
			String newList = olList.get(i).getFood().getFoodName();
			//이미 주문한 물건이 있는 경우
			if(oldList != null && oldList.equals(newList)) {
				//현재 주문했던 수량이 일치하지 않는 경우
				if(olList.get(i).getOlCount()!=tableCall.get(i).getOlCount()){
					//수량이 0일 때(주문된 물건을 취소했을 때)
					if(olList.get(i).getOlCount()==0) {
						deleteResult += orderlist.listDelete(olList.get(i));
						
					}
					updateResult += orderlist.listUpdate(olList.get(i));
				}
			//주문한 물건이 없는 경우(새로운 주문일 경우)
			} else {
				insertResult += orderlist.listInsert(olList.get(i));
			}
		}
		System.out.println("주문 변경 내역");
		System.out.println("새로 주문 들어온 갯수 : " + insertResult);
		System.out.println("주문 변경된 갯수 : " + updateResult);
		System.out.println("주문 취소된 갯수 : " + deleteResult);
		return insertResult+updateResult+deleteResult ;
	}

}
