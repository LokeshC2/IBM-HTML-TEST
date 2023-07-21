package com.example.demo;

public class CustomerAppException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomerAppException(String string) {
		super(string);
	}

	public CustomerAppException(String string, Exception e) {
		super(string, e);
	}

}
