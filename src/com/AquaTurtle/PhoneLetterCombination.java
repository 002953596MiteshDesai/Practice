package com.AquaTurtle;

import java.util.*;

public class PhoneLetterCombination {
	private static void printCombinationsPhone(String phoneNumber){
		int[] result = new int[phoneNumber.length()];
		int current = 0 ;
		
		printCombinationsPhone(result, current, phoneNumber);
	}
	
	private static void printCombinationsPhone(int[] result, int current, String phoneNumber){
		
		if(current == result.length){
			printPhoneNumbers(result, phoneNumber);
			return;
		}
		
		// We recurse
		int number = Integer.valueOf(phoneNumber.charAt(current));
		int m = getNumberOfTimesRecursion(number);
		
		if(m == -1){
			result[current] = -1;
			printCombinationsPhone(result, current + 1, phoneNumber);
		}else{
			for(int i = 0 ; i < m ; i ++){
				result[current] = i;
				printCombinationsPhone(result, current + 1, phoneNumber);
			}
		}
		
	}
	
	private static void printPhoneNumbers(int[] result, String phoneNumber){
		HashMap<Character, Character[] > map = new HashMap<>();
		map.put('2', new Character[]{'A','B','C'});
		map.put('3', new Character[]{'D','E','F'});
		map.put('4', new Character[]{'G','H','I'});
		map.put('5', new Character[]{'J','K','L'});
		map.put('6', new Character[]{'M','N','O'});
		map.put('7', new Character[]{'P','Q','R', 'S'});
		map.put('8', new Character[]{'T','U', 'V'});
		map.put('9', new Character[]{'W','X','Y', 'Z'});
		
		for(int i = 0; i < result.length; i ++){
			Character ch = phoneNumber.charAt(i);
			if(ch == '0' || ch == '1'){
				System.out.printf(String.valueOf(ch) + " ");
			}else {
				Character[] arr = map.get(ch);
				String sh = String.valueOf(arr[result[i]] );
				System.out.printf( sh + " " );
			}
		}
		System.out.println();
	}
	
	
	private static int getNumberOfTimesRecursion(int number){
		
		if(number == 0 || number == 1 ){
			return -1;
		}
		if ( (number >= 2 && number <= 6 ) || number == 8 ){
			return 2;
		}
		return  3;
	}
	
	//Leetcode Soultion
	
	//Time complexity: O(4N⋅N)
	
	char[][] values = new char[][]{
			{'a', 'b', 'c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'}
	};
	
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) return new ArrayList<>();
		Set<String> set = new HashSet<>();
		int n= 1;
		for (int i = 0; i < digits.length(); i++) {
			int len = values[digits.charAt(i) - '0' - 2].length;
			n*= len;
		}
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		while (set.size() < n) {
			for (int i = 0; i < digits.length(); i++) {
				char[] temp = values[digits.charAt(i) - '0' - 2];
				int idx = random.nextInt(temp.length);
				sb.append(temp[idx]);
			}
			set.add(sb.toString());
			sb.setLength(0);
		}
		return new ArrayList<>(set);
	}
	
}
