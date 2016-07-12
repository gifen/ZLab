package com.nefig.lab.general;

public class Scanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		String str = scan.nextLine();
		int integer = scan.nextInt();
		
		System.out.println(str);
		System.out.println(integer);
		
		scan.close();

	}

}
