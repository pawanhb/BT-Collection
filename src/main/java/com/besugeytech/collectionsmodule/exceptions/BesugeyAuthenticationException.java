package com.besugeytech.collectionsmodule.exceptions;

public class BesugeyAuthenticationException extends Exception{

	public BesugeyAuthenticationException(){
		super();
	}
	
	public BesugeyAuthenticationException(String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {
		return "Authentication Failed";
	}
}
