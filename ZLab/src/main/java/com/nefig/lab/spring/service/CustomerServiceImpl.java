package com.nefig.lab.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nefig.lab.spring.model.Customer;
import com.nefig.lab.spring.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public CustomerServiceImpl() {
	}
	
	
	private CustomerRepository customerRepository; 
	
	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

}
