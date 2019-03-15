package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.GuestRoomDTO;
import com.hotels.peregrine.other.AutoTest;

@Repository
public class HomeRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "sample";
	
	public void insertTest() {
		System.out.println("테스트중 입니다 2222");
		GuestRoomDTO lost = new GuestRoomDTO().setCheckIn(new CheckInDTO().setCheNo(1)).setGrDiAdult(1).setGrDiChild(1).setGrNo(1).setGrStaySum(1);
		AutoTest.ModelBlackTest(lost);
		/*template.insert(namespace + ".insertTest", lost);*/
		System.out.println("확인 완료");
	}
}
