package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.BreakfastDTO;

@Repository
public class BreakfastRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "break";

	//조식 리스트
	public List<BreakfastDTO> bflist() {
		
		return sql.selectList("break.bflist");
	}
	
	//조식등록 고객 디테일
	public BreakfastDTO bfDetail(int no) {
		
		return sql.selectOne("break.bfDetail",no);
	}

	//조식 등록 메소드
	public void create(BreakfastDTO bf) {
		
		sql.insert("break.insert", bf);
		
	}
	//조식 삭제
	public void delete(int no) {
		
		sql.delete("break.delete",no);
	}
	//체크아웃리스트
	public List<BreakfastDTO> checkoutlist() {
		
		return sql.selectList("break.checkoutlist");
	}

	
	
}
