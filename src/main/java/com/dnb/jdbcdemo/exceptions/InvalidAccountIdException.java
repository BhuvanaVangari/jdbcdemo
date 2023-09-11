package com.dnb.jdbcdemo.exceptions;

public class InvalidAccountIdException extends Exception {

	public InvalidAccountIdException(String msg) {

		super(msg);

	}

	public String toString() {

		return super.toString() + super.getMessage();

	}

}
