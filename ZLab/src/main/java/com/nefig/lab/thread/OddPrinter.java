package com.nefig.lab.thread;

public class OddPrinter implements Runnable{
	OddAndEven oddAndEven;
	public OddPrinter(OddAndEven o){
		oddAndEven = o;
	}
	public void run() {
		
		for (int i = 0; i < 100 ; i++){
			try {
				oddAndEven.printOdd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}