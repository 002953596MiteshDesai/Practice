package com.AquaTurtle;

import java.util.ArrayList;
import java.util.Stack;

//Time Complexity O(n)
//Space O(n)

public class MinimumRemoveParenthesis {
	
	private static String returnValidString(String str){
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> indexes  = new ArrayList<>();
		for(int i = 0 ; i < str.length(); i ++) {
			if(str.charAt(i) == '('){
				stack.push(i);
			}else if (str.charAt(i) == ')'){
				if(stack.isEmpty()){
					indexes.add(i);
				}else{
					stack.pop();
				}
			}
		}
		while(!stack.isEmpty()){
			indexes.add(stack.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < str.length(); i ++){
			if(!indexes.contains(i)){
				sb.append(str.charAt(i));
			}
		}
		
		return sb.toString();
	}
}

