package com.dnb.jdbcdemo.repo;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	
	public Optional<Customer> findByCustomerContactNumber(String customerContactNumber);
	
	public List<Customer> findAllByCustomerContactNumber(String customerContactNumber);

}