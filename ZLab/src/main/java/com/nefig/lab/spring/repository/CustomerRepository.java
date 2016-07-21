package com.nefig.lab.spring.repository;

import java.util.List;

import com.nefig.lab.spring.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}