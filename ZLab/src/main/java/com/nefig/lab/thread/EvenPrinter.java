package com.nefig.lab.thread;

public class EvenPrinter implements Runnable{
	OddAndEven oddAndEven;
	public EvenPrinter(OddAndEven o){
		oddAndEven = o;
	}
	public void run() {
		
		for (int i = 0; i < 100 ; i++){
			try {
				oddAndEven.printEven();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}