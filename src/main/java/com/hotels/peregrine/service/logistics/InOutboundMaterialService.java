package com.hotels.peregrine.service.logistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.MaterialInboundDTO;
import com.hotels.peregrine.repository.InboundRepository;
import com.hotels.peregrine.repository.OutboundRepository;

@Service
public class InOutboundMaterialService {
	
	@Autowired
	private InboundRepository repository;
	
	@Autowired
	private OutboundRepository outReposit;

	public int regist(MaterialInboundDTO dto) {
		// TODO Auto-generated method stub
		return repository.insertInbound(dto);
	}

	public List boundList(String boundName) {
		// TODO Auto-generated method stub
		if(boundName.equals("inbound")) {
			return repository.selectAllList();
		} else {
			return outReposit.selectAllList();
		}
		
	}
	
	
}
