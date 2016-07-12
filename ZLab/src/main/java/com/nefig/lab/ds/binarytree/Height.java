package com.nefig.lab.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Height {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Node root = TreeUtil.createTree(1,2,3,4,5,6,7,8,9,10,11,12,13);
		Node root = TreeUtil.createTree(1,2,3,4,5,6,7);
		TreeUtil.displayLevelOrderReverseTree(root);
		Height height = new Height();
		System.out.println("Height using recursion= " + height.getHeightUsingRecursion(root));
		System.out.println("Height without recursion= " + height.getHeight(root));
	}
	
	
	public int getHeightUsingRecursion(Node root){
		int leftHeight, rightHeight;
		if(root == null){
			return 0;
		}else{
			leftHeight = getHeightUsingRecursion(root.getLeft());
			rightHeight = getHeightUsingRecursion(root.getRight());
			
			if(leftHeight > rightHeight){
				return leftHeight + 1;
			}else{
				return rightHeight + 1;
			}
		}
	}
	
	public int getHeight(Node root){
		Queue<Node> queue = new LinkedList<>();
		int level = 0;
		if(root == null) {
			return 0;
		}
		
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()){
			root = queue.remove();
			//System.out.print("H :" + (root== null? "NULL":root.getData()) + " "); 
			if(root == null){
				if(!queue.isEmpty()){
					queue.add(null);
				}
				
				level++;
			}else{								
				if(root.getLeft()!= null){
					queue.add(root.getLeft());
				}
				if(root.getRight() != null){
					queue.add(root.getRight());
				}
						
			}
		}
		System.out.println("");
		return level;
	}
	
	

}
