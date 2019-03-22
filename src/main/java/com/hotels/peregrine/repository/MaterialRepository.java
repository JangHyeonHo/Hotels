package com.hotels.peregrine.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.command.MaterialCountCommand;
import com.hotels.peregrine.model.MaterialDTO;
import com.hotels.peregrine.other.AutoPaging;

@Repository
public class MaterialRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "material";
	
	//자재 리스트 관리
	public List<MaterialCountCommand> getMaterialList(AutoPaging page) {
		// TODO Auto-generated method stub
		Integer minNum = ((page.getPage()-1)*page.getLimit())+1;
		Integer maxNum = minNum+page.getLimit()-1;
		HashMap<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("minNum", minNum);
		mapping.put("maxNum", maxNum);
		return template.selectList(namespace + ".materialList", mapping);
	}
	
	//자재 등록하는 것
	public int insertMaterial(MaterialDTO dto) {
		// TODO Auto-generated method stub
		return template.insert(namespace + ".insertMaterial", dto);
	}
	
	//해당 자재의 전체 리스트 카운트
	public int getAllListCnt() {
		// TODO Auto-generated method stub
		return template.selectOne(namespace + ".listCnt");
	}
	
	//해당 자재를 삭제할 때
	public int deleteMaterial(int no) {
		// TODO Auto-generated method stub
		return template.delete(namespace + ".deleteMaterial", no);
	}
	
	//해당 자재에 대한 정보를 가져올 때
	public MaterialDTO oneMaterialCall(int no) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace + ".oneMaterial", no);
	}
	
	//재료 검색할 때
	public List<MaterialDTO> searchMaterialList(HashMap<String, String> mapping) {
		// TODO Auto-generated method stub
		return template.selectList(namespace + ".searchList", mapping);
	}
	
	
}
