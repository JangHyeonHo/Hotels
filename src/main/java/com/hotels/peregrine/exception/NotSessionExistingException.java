package com.hotels.peregrine.exception;

public class NotSessionExistingException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "존재하지 않는 세션입니다.";
	}
	
}
