package com.AquaTurtle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
}
