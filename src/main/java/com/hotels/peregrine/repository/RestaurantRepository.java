package com.hotels.peregrine.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.command.RestaurantChairCommand;
import com.hotels.peregrine.command.RestaurantCommand;
import com.hotels.peregrine.model.RestaurantDTO;
import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.other.AutoPaging;

@Repository
public class RestaurantRepository {

	@Autowired
	private SqlSessionTemplate template;
	
	public void rinsert(RestaurantDTO dto) {
		
		template.insert("restaurant.rinsert",dto);
		
	}
	
	public void resercusinsert(RestaurantReservationDTO dto) {
		
		template.insert("restaurant.resercusinsert",dto);
		
	}
	
	
	public List<RestaurantCommand> resnamesearch(String value) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("value", value);
		return template.selectList("restaurant.namelist",map);
	}
	
	public RestaurantCommand resname(String value,String dateTime) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("value", value);
		map.put("dateTime",dateTime);
		
		return template.selectOne("restaurant.namelist",map);
	}
	
	public void resinsert(List<RestaurantReservationDTO> resList) {

		
		for(RestaurantReservationDTO dto : resList ){
		template.insert("restaurant.resinsert",dto);
		}
	}
	
	
	public List<RestaurantReservationDTO> reslist(AutoPaging paging) {
		Integer minNum = ((paging.getPage()-1)*paging.getLimit())+1;
		Integer maxNum = minNum+paging.getLimit()-1;
		HashMap<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("minNum", minNum);
		mapping.put("maxNum", maxNum);
		return template.selectList("restaurant.reslist",mapping);
	}
	
	public List<RestaurantReservationDTO> reserDetail(long num){
		
		return template.selectList("restaurant.resdetail",num);
	}
	
	public void resdelete(long no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		template.delete("restaurant.resdelete",map);
	}
	
	public void resdeleteTwo(long no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		template.delete("restaurant.resdeleteTwo",map);
	}

	public List<RestaurantChairCommand> AllChairs(String resName) {
		// TODO Auto-generated method stub
		return template.selectList("restaurant.chairsCall", resName);
	}

	public int getAllListCnt() {
		// TODO Auto-generated method stub
		return template.selectOne("restaurant.listCnt");
	}
	
}
