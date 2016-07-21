package com.nefig.lab.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nefig.lab.spring.service.CustomerService;

public class SpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = getConfigurationApplicationContext();
		CustomerService service = context.getBean("customerService", CustomerService.class);
		System.out.println(service.findAll().get(0));

	}

	private static ApplicationContext getAnnotatedApplicationContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
		return context;
	}
	

	private static ApplicationContext getXMLApplicationContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		return context;
	}
	


	private static ApplicationContext getConfigurationApplicationContext() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		return context;
	}

}
