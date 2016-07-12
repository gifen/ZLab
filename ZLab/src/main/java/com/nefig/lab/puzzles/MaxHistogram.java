package com.nefig.lab.puzzles;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaxHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxHistogram mh = new MaxHistogram();
	        int input[] = {2,2,2,6,1,5,4,2,2,2,2};
	        int maxArea = mh.getMaxHistogram(input);
	        System.out.println(maxArea);
	        System.out.println(mh.getMaxHistogram02(input));
	        assert maxArea == 12;

	}
	
	private int getMaxHistogram(int[] input){
		int maxArea = 0;
		int area = 0;
		//Stack<Integer> stack = new Stack<>();
		Deque<Integer> stack = new LinkedList<Integer>();
		int i = 0;
		
		for(i=0; i<input.length;){
			if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
				stack.offerFirst(i++);
			}else{
				int top = stack.pollFirst();
				
				if(stack.isEmpty()){
					area = input[top] * i;
				}else{
					area = input[top] * (i - stack.peekFirst() -1);
				}
				
				if(area > maxArea){
					maxArea = area;
				}
			}
			
		}
		
		while (!stack.isEmpty()){
			int top = stack.pollFirst();
			
			if(stack.isEmpty()){
				area = input[top] * i;
			}else{
				area = input[top] * (i - stack.peekFirst()  - 1);
			}
			
			if(area > maxArea){
				maxArea = area;
			}
		}
		
		return maxArea;
	}
	
	

	private int getMaxHistogram02(int[] A){
		int maxArea = -1;
		if(A== null || A.length == 0){
			return maxArea;
		}
		
		Stack<StackItem> S = new Stack<>();
		S.push(new StackItem(Integer.MIN_VALUE, -1));
		
		for(int i=0; i<= A.length; i++){
			StackItem cur = new StackItem((i<A.length ? A[i]:Integer.MIN_VALUE), i);
			
			if(cur.height > S.peek().height){
				S.push(cur);
				continue;
			}
			
			while(S.size() > 1){
				StackItem prev = S.peek();
				
				int area = (i- prev.index) * prev.height;
				if(area>maxArea){
					maxArea = area;
				}
				
				prev.height = cur.height;
				if(prev.height > S.get(S.size() - 2).height){
					break;
				}
				S.pop();
				
			}
		}
		return maxArea;
	}

}

class StackItem{
	int height;
	int index;
	public StackItem(int height, int index) {
		super();
		this.height = height;
		this.index = index;
	}
	
	
}

