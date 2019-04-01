package com.hotels.peregrine.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.FoodDTO;
import com.hotels.peregrine.other.AutoPaging;

@Repository
public class FoodRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "food";
	
	//음식 등록하기
	public int regist(FoodDTO food) {
		// TODO Auto-generated method stub
		return template.insert(namespace + ".registFood", food);
	}

	//등록한 음식 번호를 바로 찾는 코드
	public int searchNo(FoodDTO food) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace + ".foodNoSelect",food);
	}

	//모든 음식 리스트를 불러오기
	public List<FoodDTO> listSelect(AutoPaging page, String kind, String menu) {
		// TODO Auto-generated method stub
		Integer minNum = ((page.getPage()-1)*page.getLimit())+1;
		Integer maxNum = minNum+page.getLimit()-1;
		HashMap<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("minNum", minNum);
		mapping.put("maxNum", maxNum);
		mapping.put("kind", kind);
		mapping.put("menu", menu);
		return template.selectList(namespace+".foodList",mapping);
	}
	
	//음식의 리스트 카운트를 불러오기
	public int listCount() {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+".foodCount");
	}
	
	//메뉴등록이 어떻게 되어있는지 확인하는 코드
	public String selectManuRegist(int no) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+".manuChangeRegistCall",no);
	}
	
	//확인한 메뉴등록의 상태를 변경함
	public int changeRegist(int no, String changeReg) {
		// TODO Auto-generated method stub
		HashMap<String,Object> mapping = new HashMap<String,Object>();
		mapping.put("no", no);
		mapping.put("regist", changeReg);
		return template.update(namespace+".manuChange",mapping);
	}
	
	//선택한 음식을 삭제함
	public int deleteFood(int no) {
		// TODO Auto-generated method stub
		return template.delete(namespace+".deleteFood",no);
	}

	//주문에 사용할 음식 이믈과 가격가져오기
	public FoodDTO orderFoodCall(int foodNo) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+".namePriceCall",foodNo);
	}
	
	//주문에 사용할 음식종류의 총 개수를 가져오기
	public int allCountCall(String value) {
		// TODO Auto-generated method stub
		try {
			return template.selectOne(namespace + ".menuCounting", value);
		}catch(NullPointerException e) {
			return 0;
		}
	}
	
	
}
