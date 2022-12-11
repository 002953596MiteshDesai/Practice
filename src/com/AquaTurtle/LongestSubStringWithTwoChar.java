package com.AquaTurtle;

import java.util.*;

public class LongestSubStringWithTwoChar {
	public static String longestSubStringWithTwoChars(String str){
		if(str == null || str.length() <= 2){
			return str;
		}
		String maxString = "";
		int maxIndex = 0;
		int start = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0 ; i < str.length(); i ++) {
			Character ch = str.charAt(i);
			if(map.size() < 2){
				if(!map.containsKey(ch)){
					map.put(str.charAt(i), i);
					maxIndex = i;
				}
			}
			else{
				if(map.containsKey(ch)){
					maxIndex = i;
					if(maxString.length() < str.substring(start, i+1).length()){
						maxString = str.substring(start, i+1);
					}
					
					continue;
				}
				map.remove(str.charAt(maxIndex));
				maxIndex = maxIndex + 1;
				start = maxIndex;
				
			}
			if(maxString.length() < str.substring(start, i+1).length()){
				maxString = str.substring(start, i+1);
			}
		}
		
		
		
		return maxString;
		
	}
	
	//Leetcode Solution
	//Complexity O(n)
	//Space O(1)
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int n = s.length();
		if (n < 3) return n;
		
		// sliding window left and right pointers
		int left = 0;
		int right = 0;
		// hashmap character -> its rightmost position
		// in the sliding window
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		
		int max_len = 2;
		
		while (right < n) {
			// when the slidewindow contains less than 3 characters
			hashmap.put(s.charAt(right), right++);
			
			// slidewindow contains 3 characters
			if (hashmap.size() == 3) {
				// delete the leftmost character
				int del_idx = Collections.min(hashmap.values());
				hashmap.remove(s.charAt(del_idx));
				// move left pointer of the slidewindow
				left = del_idx + 1;
			}
			
			max_len = Math.max(max_len, right - left);
		}
		return max_len;
	}
}
