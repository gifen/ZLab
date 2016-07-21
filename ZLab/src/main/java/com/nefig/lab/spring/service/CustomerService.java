package com.nefig.lab.spring.service;

import java.util.List;

import com.nefig.lab.spring.model.Customer;

public interface CustomerService {

	List<Customer> findAll();

}