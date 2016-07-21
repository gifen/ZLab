package com.nefig.lab.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.nefig.lab.spring.model.Customer;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	@Value("${first.name}")
	private String firstName;
	@Override
	public List<Customer> findAll(){
		
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName("Gayakan");
		
		customers.add(customer);
		
		return customers;
		
	}

}
