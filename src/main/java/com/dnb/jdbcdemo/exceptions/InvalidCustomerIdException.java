package com.dnb.jdbcdemo.exceptions;

public class InvalidCustomerIdException extends Exception {

	public InvalidCustomerIdException(String msg) {

		super(msg);

	}

	public String toString() {

		return super.toString() + super.getMessage();

	}

}