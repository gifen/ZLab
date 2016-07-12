package com.nefig.lab.general;

import java.util.LinkedList;

public class BlockingQueue<E> {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<String> queue = new BlockingQueue<String>(1);
		
	queue.put("");
		queue.take();
		queue.take();
		//queue.take();
		System.out.println("Done");

	}
	
	public BlockingQueue(int size){
		this.size = size;
	}
	
	private LinkedList<E> list = new LinkedList<E>();
	private int size;
	private Object lock = new Object();
	
	private void put(E obj) throws InterruptedException{
		synchronized(lock){
			while(list.size() >= size){
				System.out.println("waiting for empty queue");
				lock.wait();
			}
			
			list.add(obj);
			
			lock.notifyAll();
			
			
		}
	}
	
	private E take() throws InterruptedException{
		
		E obj;
		synchronized (lock) {
			while(list.size() ==0){
				System.out.println("waiting for items");
				lock.wait();
			}
			obj = list.removeFirst();
			lock.notifyAll();
		}
		
		return obj;
	}

}
