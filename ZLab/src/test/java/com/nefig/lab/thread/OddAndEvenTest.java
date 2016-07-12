package com.nefig.lab.thread;

import org.junit.Before;
import org.junit.Test;


public class OddAndEvenTest {
	
	private OddPrinter odd;
	private EvenPrinter even;
	
	@Before
	public void setUp(){
		OddAndEven oddAndEven = new OddAndEven();
		odd = new OddPrinter(oddAndEven);
		even = new EvenPrinter(oddAndEven);
	}
	
	@Test
	public void simulate(){
		Thread thread1= new Thread(odd);
		Thread thread2 = new Thread(even);
		
		thread2.start();
		thread1.start();
		
		try {
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
