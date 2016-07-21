package com.nefig.lab.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.nefig.lab.spring.repository.CustomerRepository;
import com.nefig.lab.spring.repository.HibernateCustomerRepositoryImpl;
import com.nefig.lab.spring.service.CustomerService;
import com.nefig.lab.spring.service.CustomerServiceImpl;

@Configuration
@ComponentScan({"com.nefig.lab.spring"})
@PropertySource("app.properties")
public class AppConfig {

	@Bean(name="customerService")
	@Scope("singleton")
	public CustomerService getCustomerService(){
		CustomerServiceImpl customerService= new CustomerServiceImpl();
		// commented for autowiring customerService.setCustomerRepository(getCustomerRepository());
		return customerService;
	}
	
	
	@Bean
	public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
}
