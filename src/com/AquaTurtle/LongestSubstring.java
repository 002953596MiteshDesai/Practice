package com.AquaTurtle;

import java.util.HashSet;

public class LongestSubstring {
	//Prof Format  Complexity O(n)
	private static String longestNonRepeatingSubstring(String str){
		if(str.length() <=1){
			return str;
		}
		HashSet<Character> set = new HashSet<>();
		int start = 0;
		int maxLength = 0;
		String maxNonRepeated = "";
		
		for(int i = 0 ; i < str.length() ; i ++){
			if(!set.contains(str.charAt(i))){
				set.add(str.charAt(i));
				if(maxLength < i - start +1 ){
					maxLength = i - start +1;
					maxNonRepeated = str.substring(start, i +1);
				}
			}else{
				while(set.contains(str.charAt(i))){
					set.remove(str.charAt(start));
					start++;
				}
				set.add(str.charAt(i));
			}
		}
		return maxNonRepeated;
	}
	
	//Leetcode Format
	
	public int lengthOfLongestSubstring(String s) {
		if(s.length() <=1){
			return s.length();
		}
		HashSet<Character> set = new HashSet<>();
		int start = 0;
		int maxLength = 0;
		String maxNonRepeated = "";
		
		for(int i = 0 ; i < s.length() ; i ++){
			if(!set.contains(s.charAt(i))){
				set.add(s.charAt(i));
				if(maxLength < i - start +1 ){
					maxLength = i - start +1;
					maxNonRepeated = s.substring(start, i +1);
				}
			}else{
				while(set.contains(s.charAt(i))){
					set.remove(s.charAt(start));
					start++;
				}
				set.add(s.charAt(i));
			}
		}
		return maxNonRepeated.length();
	}
}
