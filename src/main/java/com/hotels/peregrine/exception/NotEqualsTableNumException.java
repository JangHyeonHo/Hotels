package com.hotels.peregrine.exception;

public class NotEqualsTableNumException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "세션에 저장된 테이블이 일치하지 않습니다.";
	}
	
	
}
