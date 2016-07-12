package com.nefig.lab.thread;

public class OddAndEven {
	
	private int counter;
	
	public synchronized void printEven() throws InterruptedException{
		
		while (counter %2 != 0){
			wait();
		}
		System.out.println(counter);
		counter++;	
		notifyAll();
	}
	
	public synchronized void printOdd()  throws InterruptedException{

		while (counter %2 == 0){
			wait();
		}
		System.out.println(counter);
		counter++;	
		notifyAll();
	}
}
