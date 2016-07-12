package com.nefig.lab.puzzles;

import java.util.ArrayList;
import java.util.List;

public class FindNonRepeatingDigit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(1);
		arr.add(2);
		arr.add(2);
		arr.add(3);
		arr.add(3);
		arr.add(4);

		arr.add(5);
		new FindNonRepeatingDigit().duplicate(arr);

	}
	
	public void duplicate(List<Integer> arr){
		if(arr == null){
			System.out.println("Array Empty");
		}
		int value = 0;
		for(int arrayvalue : arr){
			value = value ^ arrayvalue;			
		}
		
		System.out.println("Value" + value);
	}

}
