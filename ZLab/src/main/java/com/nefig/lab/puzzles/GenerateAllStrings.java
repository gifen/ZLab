package com.nefig.lab.puzzles;

public class GenerateAllStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateAllStrings obj = new GenerateAllStrings();
		
		/*int count = 4;
		obj.array = new String[count];
		obj.binaryString(count);
		*/
		
		int count = 4;
		int k = 26;
		obj.array = new String[count];
		obj.kString(count, k);

	}
	
	private String[] array;
	
	public void binaryString(int n){
		if(n <1){
			printArray();
		}else{
			array[n-1] = "0";
			binaryString(n-1);
			array[n-1]="1";
			binaryString(n-1);
			
		}
	}
	
	public void kString(int n, int k){
		if (n<1){
			printArray();
		}else{
			for(int j = 0; j< k; j++){
				array[n-1]=j+"";
				kString(n-1,k);
			}
		}
	}

	private void printArray() {
		if(array == null || array.length ==0){
			return;
		}
		for(String s:array){
			System.out.print(s);	
		}
		System.out.println("");
		
	}

}
