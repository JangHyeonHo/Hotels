package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.MaterialDTO;

@Repository
public class MaterialRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "material";

	public List<MaterialDTO> getMaterialList() {
		// TODO Auto-generated method stub
		return template.selectList(namespace + ".materialList");
	}

	public int insertMaterial(MaterialDTO dto) {
		// TODO Auto-generated method stub
		return template.insert(namespace + ".insertMaterial", dto);
	}
	
	
}
