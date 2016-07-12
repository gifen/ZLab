package com.nefig.lab.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BTInsert {
	
	private static BTInsert obj = new BTInsert();
	
	private BTInsert(){
		
	}
	
	public static BTInsert getInstance(){
		return obj;
	}
	
	public Node insert(Node root, int data){
		Queue<Node> queue = new LinkedList<>();
		Node temp;
		Node newNode = createNode(data);
		if(root == null){
			return newNode;
		}
		queue.add(root);
		
		while(!queue.isEmpty()){
			temp = queue.remove();
			if(temp.getLeft()!=null){
				queue.add(temp.getLeft());
			}else{
				temp.setLeft(newNode);
				return root;
			}
			
			if(temp.getRight() != null){
				queue.add(temp.getRight());
			}else{
				temp.setRight(newNode);
				return root;
			}
		}
		return root;
	}

	private Node createNode(int data) {
		Node node = new Node();
		node.setData(data);
		return node;
	}

}
