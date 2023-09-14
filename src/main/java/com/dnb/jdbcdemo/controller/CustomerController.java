package com.dnb.jdbcdemo.controller;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.DataNotFoundException;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;
import com.dnb.jdbcdemo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") int customerId) throws  IdNotFoundException, InvalidCustomerIdException{
		if(customerService.customerExistsById(customerId)) {
			customerService.deleteCustomerById(customerId);
			return (ResponseEntity<?>) ResponseEntity.noContent().build();
		}
		else {
			throw new InvalidCustomerIdException("Customer id not valid");
		}
	}
	
	@GetMapping("/cn/{customerContactNumber:^[0-9]{10}$}")
	public ResponseEntity<?>getCustomerByContactNumber(@PathVariable("customerContactNumber")String customerContactNumber) throws InvalidContactNumberException{
		Optional<Customer>optional=customerService.getCustomerByCustomerContactNumber(customerContactNumber);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new InvalidContactNumberException("Contact number is invalid");
		}
	}
	
	@GetMapping("/allCustomers/{customerContactNumber}")
	public ResponseEntity<?> getAllCustomersByCustomerContactNumber(@PathVariable("customerContactNumber")String customerContactNumber) throws InvalidContactNumberException, DataNotFoundException{
		List<Customer>list=(List<Customer>)customerService.getAllCustomersByCustomerContactNumber(customerContactNumber);
		if(list.isEmpty()) {
			throw new DataNotFoundException("No Data Found");
		}
		else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/ci/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId")int customerId) throws InvalidCustomerIdException{
		Optional<Customer>optional=customerService.getCustomerById(customerId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new InvalidCustomerIdException("Customer id is not valid");
		}
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer){
		Customer customer2=customerService.createCustomer(customer);
		return new ResponseEntity(customer2,HttpStatus.CREATED);
	}
}
