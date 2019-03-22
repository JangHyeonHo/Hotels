package com.hotels.peregrine.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.RestaurantDTO;
import com.hotels.peregrine.model.RestaurantReservationDTO;

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
	
	
	public List<RestaurantReservationDTO> resnamesearch() {
		
		return template.selectList("restaurant.namelist");
	}
	
	public void resinsert(RestaurantReservationDTO dto) {
		
		template.insert("restaurant.resinsert",dto);
	}
	
	
	public List<RestaurantReservationDTO> reslist() {
		
		return template.selectList("restaurant.reslist");
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
	
}
