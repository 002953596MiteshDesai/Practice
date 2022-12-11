package com.AquaTurtle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Time Complexity: O(NKlog⁡K)
//Space O(NK)

public class GroupAnagrams {
	
	private static ArrayList<ArrayList<String>> groupAnagrams(String[] arr){
		
		ArrayList<ArrayList<String>> listOfGroupedAnagrams = new ArrayList<>();
		
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		for (String str : arr) {
			char[] chArr = str.toCharArray();
			Arrays.sort(chArr);
			
			String anagram = String.valueOf(chArr);
			if(!map.containsKey(anagram)){
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				map.put(anagram, list);
			}else{
				ArrayList<String> list = map.get(anagram);
				list.add(str);
				map.put(anagram, list);
			}
		}
		
		for (ArrayList<String> list: map.values()) {
			listOfGroupedAnagrams.add(list);
		}
		
		return listOfGroupedAnagrams;
		
	}
	
	//Leetcode Solution
	
	public List<List<String>> groupAnagrams2(String[] strs) {
		int n=strs.length;
		HashMap<String,ArrayList<String>> map =new HashMap<>();
		List<List<String>> answer =new ArrayList<>();
		
		for(int i=0;i<n;i++){
			char [] ch=strs[i].toCharArray();
			Arrays.sort(ch);
			String temp=new String(ch);
			if(map.containsKey(temp)){
				map.get(temp).add(strs[i]);
			}
			else{
				ArrayList<String> t=new ArrayList<>();
				t.add(strs[i]);
				map.put(temp,t);
			}
		}
		
		for(String key:map.keySet()){
			answer.add(map.get(key));
		}
		
		return answer;
		
	}
}
