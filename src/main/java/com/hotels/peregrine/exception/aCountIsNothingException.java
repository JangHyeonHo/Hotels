package com.hotels.peregrine.exception;

public class aCountIsNothingException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "해당 수량이 더 이상 존재하지 않음";
	}
	
	
}
