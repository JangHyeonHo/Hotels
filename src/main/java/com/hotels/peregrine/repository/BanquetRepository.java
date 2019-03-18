package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.BanquetDTO;
import com.hotels.peregrine.model.BanquetRentalDTO;

@Repository
public class BanquetRepository {

	@Autowired
	private SqlSessionTemplate template;
	
	// 연회장 등록 
	 public void binsert(BanquetDTO dto) {

		 template.insert("banquet.Binsert",dto);
		 
	 }
	 
	 public void brinsert(BanquetRentalDTO dto) {
		 
		 template.insert("banquet.Brinsert",dto);
	 }
	 
	 
	 public List<String> bnamelist() {
		 
		 return template.selectList("banquet.Bnamelist");
	 }
	 
	 public List<BanquetRentalDTO> banquetList(){
		 
		 return template.selectList("banquet.Blist");
	 }
	 
	 public BanquetRentalDTO Bdetail(long num) {
		 
		 return template.selectOne("banquet.bDetail",num);
	 }
	 
	 public Integer dateRefresh1(long num) {
		 
		 return template.update("banquet.refresh1",num);
	 }
	 public Integer dateRefresh2(long num) {
		 
		 return template.update("banquet.refresh2",num);
	 }
	 
}
