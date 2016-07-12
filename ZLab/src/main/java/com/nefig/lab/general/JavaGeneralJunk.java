package com.nefig.lab.general;

public class JavaGeneralJunk {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer i = new Integer(5);
		Integer j = new Integer(5);
		if (i == j)
			System.out.println("Equal");
		else
			System.out.println("Not Equal");



	}

	public static void fibo(int i , int j,int n){
		System.out.print(i+" "+j);
		for(int counter = 0; counter< n; counter++){
			int c= i+j;
			i=j;
			j=c;
			System.out.print(" "+c);
		}
		
	}



}
