package com.hotels.peregrine.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.BanquetDTO;
import com.hotels.peregrine.model.BanquetRentalDTO;
import com.hotels.peregrine.other.AutoPaging;

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
	 
	 public List<BanquetRentalDTO> banquetList(AutoPaging paging){
		 Integer minNum = ((paging.getPage()-1)*paging.getLimit())+1;
			Integer maxNum = minNum+paging.getLimit()-1;
			HashMap<String, Object> mapping = new HashMap<String, Object>();
			mapping.put("minNum", minNum);
			mapping.put("maxNum", maxNum);
		 return template.selectList("banquet.Blist",mapping);
	 }
	 
	 public BanquetRentalDTO Bdetail(long num) {
		 
		 return template.selectOne("banquet.bDetail",num);
	 }
	 
	 public Integer dateRefresh1(long num) {
		 
		 return template.update("banquet.refreshOne",num);
	 }
	 
	 public Integer dateRefresh2(long num) {
		 
		 return template.update("banquet.refreshTwo",num);
	 }
	 
	 public void bdelete(long num) {

		 template.delete("banquet.bdelete",num);
		 
	 }

	public int getAllListCnt() {
		// TODO Auto-generated method stub
		return template.selectOne("banquet.listCnt");
	}
	 
}
