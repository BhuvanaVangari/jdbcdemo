package com.dnb.jdbcdemo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;

@ControllerAdvice
public class AppAdvice {
	
	@ExceptionHandler(InvalidAccountIdException.class)
	public ResponseEntity<?> invalidAccountIdExceptionHandler(InvalidAccountIdException e){
		Map<String, String>map=new HashMap<>();
		map.put("message", "accountId not found");
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
}
