package com.dnb.jdbcdemo.exceptions;

public class DataNotFoundException extends Exception {
	public DataNotFoundException(String msg) {
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}
}
