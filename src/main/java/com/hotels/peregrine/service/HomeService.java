package com.hotels.peregrine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.repository.HomeRepository;

@Service
public class HomeService {
	
	@Autowired
	private HomeRepository home;
	
	public void TestAction() {
		System.out.println("제대로 실행되고 있습니다.");
		home.insertTest();
		System.out.println("완료됐습니다.");
	}
}
