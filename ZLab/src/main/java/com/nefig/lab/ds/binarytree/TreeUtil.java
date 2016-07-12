package com.nefig.lab.ds.binarytree;

public class TreeUtil {
	
	public static Node createTree(int ...data){
		if(data == null){
			return null;
		}
		
		Node root = null;
		BTInsert btInsert = BTInsert.getInstance();
		for(int i=0;i<data.length;i++){
			root = btInsert.insert(root, data[i]);			
		}
		return root;
	}
	
	public static void displayTree(Node root){

		DisplayLevelOrder display = DisplayLevelOrder.getInstance();
		display.print(root);
	}
	public static void displayLevelOrderReverseTree(Node root){

		DisplayLevelOrder display = DisplayLevelOrder.getInstance();
		display.printReverse(root);
	}

}
