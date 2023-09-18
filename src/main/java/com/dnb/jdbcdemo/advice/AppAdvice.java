package com.dnb.jdbcdemo.advice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.dnb.jdbcdemo.exceptions.DataNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;

@ControllerAdvice
public class AppAdvice {
//to manage all the custom + predefined exceptions
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason="invalid id provided")
	@ExceptionHandler(InvalidAccountIdException.class)
	public void invalidAccountIdExceptionHandler(InvalidAccountIdException e){
//		Map<String, String>map=new HashMap<>();
//		map.put("message", "accountId not found");
//		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
//		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Map<String,String>> handleException(HttpRequestMethodNotSupportedException e)throws IOException{
		String provided = e.getMethod();
		List<String> supported= List.of(e.getSupportedMethods());
		String error=provided+ " is not one of the HTTP supported methods ("+String.join(", ", supported)+")";
		Map<String, String>errorResponse=Map.of("error",error,
				"message",e.getLocalizedMessage(),
				"status",HttpStatus.METHOD_NOT_ALLOWED.toString()
				);
		return new ResponseEntity<>(errorResponse,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler({MethodArgumentTypeMismatchException.class,
		TypeMismatchException.class})
	public ResponseEntity<Map<String,String>>handleException(TypeMismatchException e){
		Map<String, String>map=Map.of(
		"message", e.getLocalizedMessage(),
		"HttpStatus", HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidCustomerIdException.class)
	public ResponseEntity<?> invalidCustomerIdExceptionHandler(InvalidCustomerIdException e){
		Map<String, String>map=new HashMap<>();
		map.put("message", "customerId not found");
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidContactNumberException.class)
	public ResponseEntity<?> invalidContactNumberExceptionHandler(InvalidContactNumberException e){
		Map<String, String>map=new HashMap<>();
		map.put("message", "contactNumber not found");
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<?> dataNotFoundExceptionHandler(DataNotFoundException e){
		Map<String, String>map=new HashMap<>();
		map.put("message", "data not found");
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatusCode status, HttpRequest request) {
//		Map<String,Object> responseBody=new LinkedHashMap<>();
//		responseBody.put("timestamp", LocalDateTime.now());
//		responseBody.put("status", status.value());
//		
//		List<String>errorKeys=ex.getBindingResult().getFieldErrors()
//				.stream()
//				.map(x->x.getField())
//				.collect(Collectors.toList());
//		//responseBody.put("errors", errorKeys);
//		
//		List<String>errorMessages=ex.getBindingResult().getFieldErrors()
//				.stream()
//				.map(x->x.getRejectedValue())
//				.collect(Collectors.toList());
//		//responseBody.put("errors", errorMessages);
//		
//		//Map<String, String>errors=new HashMap<>();
//		
//		Map<String, String>result=IntStream.range(0, errorKeys.size())
//		  .boxed()
//		  .collect(Collectors.toMap(errorKeys::get, errorMessages::get));
//		responseBody.put("errors", result);
//		
//		
//		return new ResponseEntity<>(responseBody,headers,status);
//	}
}
