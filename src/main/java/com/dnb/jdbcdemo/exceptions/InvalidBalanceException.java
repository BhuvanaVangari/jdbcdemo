package com.dnb.jdbcdemo.exceptions;

public class InvalidBalanceException extends Exception {
	public InvalidBalanceException(String msg) {
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}
}
