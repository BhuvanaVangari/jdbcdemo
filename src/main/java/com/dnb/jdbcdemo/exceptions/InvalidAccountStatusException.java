package com.dnb.jdbcdemo.exceptions;

public class InvalidAccountStatusException extends Exception {
	public InvalidAccountStatusException(String msg) {
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}
}
