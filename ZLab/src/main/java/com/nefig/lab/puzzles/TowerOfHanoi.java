package com.nefig.lab.puzzles;

import java.util.LinkedList;
import java.util.Stack;

public class TowerOfHanoi {
	LinkedList<String> fromPeg = new LinkedList<String>();
	LinkedList<String> auxPeg = new LinkedList<String>();
	LinkedList<String> toPeg = new LinkedList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			TowerOfHanoi obj = new TowerOfHanoi();
			//obj.buildTower(3,"A","B", "C");
			int count = 3;
			obj.populatefromPeg(count);
			obj.calTower(count);
	}
	
	
	private void calTower(int count) {
		buildTower(3,fromPeg,auxPeg,toPeg);
		
	}


	private void populatefromPeg(int count) {
		for(int c=1; c<=count;c++){
			fromPeg.addFirst(""+c);
		}
		
	}


	public void buildTower(int diskCount, String from, String aux, String to){
		
		if(diskCount==1){
			System.out.println("Moving disk "+ diskCount + " from " +from +
					" to " +to);
			return;
		}
		
		buildTower(diskCount-1,from,to, aux);
		System.out.println("Moving disk "+ diskCount + " from " +from +
				" to " +to);
		buildTower(diskCount-1, aux, to, from);
	}
	

	public void buildTower(int diskCount, LinkedList<String> from, 
			LinkedList<String> aux, LinkedList<String> to){
		
		if(diskCount==1){
		//	System.out.println("Moving disk "+ diskCount + " from " +from +	" to " +to);
			to.addFirst(from.pop());
			printPegs();
			return;
		}
		
		buildTower(diskCount-1,from,to, aux);
		//System.out.println("Moving disk "+ diskCount + " from " +from +" to " +to);
		to.addFirst(from.pop());
		printPegs();

		buildTower(diskCount-1, aux, to, from);
	}
	
	public void printPegs(){
		
		System.out.println("");System.out.println("");System.out.println("");System.out.println("");
		int fromSize = fromPeg.size();
		int auxSize = auxPeg.size();
		int toSize = toPeg.size();
		
		int length = (fromSize > auxSize)? ((fromSize > toSize)? fromSize : toSize) :
					((auxSize > toSize)?auxSize:toSize);
		
		for(int counter =length; counter >=0; counter -- ){
			String a = " ";
			String b = " ";
			String c = " ";
			if(counter < fromSize){
				a = fromPeg.get(counter);
			}
			if(counter < auxSize){
				b= auxPeg.get(counter);
				
			}
			if(counter < toSize){
				c = toPeg.get(counter);
			}
			
			System.out.println(a + "       " + b + "       " + c);
			
		}

		System.out.println("A" + "       " + "B" + "       " + "C");
		
		
	}
}
