package com.nefig.lab.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DisplayLevelOrder {
	private static DisplayLevelOrder obj = new DisplayLevelOrder();
	
	private DisplayLevelOrder(){
		
	}
	
	public static DisplayLevelOrder getInstance(){
		return obj;
	}
	
	public void print(Node root){
		Node temp;
		Queue<Node> queue = new LinkedList<>();
		
		if(root == null){
			return;
		}
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			temp = queue.remove();
			System.out.print(temp.getData() + " ");
			
			if(temp.getLeft()!=null){
				queue.add(temp.getLeft());
			}
			if(temp.getRight()!=null){
				queue.add(temp.getRight());
			}
		}
		System.out.println("");
	}
	
	public void printReverse(Node root){
		Node temp;
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		
		if(root == null){
			return;
		}
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			temp = queue.remove();

			if(temp.getRight()!=null){
				queue.add(temp.getRight());
			}	
			if(temp.getLeft()!=null){
				queue.add(temp.getLeft());
			}
			
			stack.add(temp);
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getData() + " ");
		}
		
		System.out.println("");
	}

}
