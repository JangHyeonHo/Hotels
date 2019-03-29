package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.CardPayDTO;
import com.hotels.peregrine.model.PaymentDTO;

@Repository
public class PaymentRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "payment";

	public int payment(PaymentDTO payment) {
		// TODO Auto-generated method stub
		return template.insert(namespace+".insertPay", payment);
	}

	public String getPayNo(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace + ".selectNo", paymentDTO);
	}

}
