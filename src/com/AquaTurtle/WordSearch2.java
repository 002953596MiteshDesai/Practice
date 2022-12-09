package com.AquaTurtle;

import java.util.ArrayList;
//Horizontal & Vertical travarsal
// Complexity O(n3)
public class WordSearch2 {
	private static ArrayList<String> getAllMatches(String[][] matrix, String[] words){
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		ArrayList<String> matchedWords = new ArrayList<>();
		for (String word : words) {
			boolean[][] visited = new boolean[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					findWord(matrix, word, 0, i, j, visited, matchedWords);
				}
			}
			
		}
		return matchedWords;
	}
	
	private static void findWord(String[][] matrix, String word, int index, int row, int col, boolean[][] visited, ArrayList<String> matchedWords){
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		if(row < 0 || col < 0 || row >= maxRow || col >= maxCol ){
			return;
		}
		
		if(visited[row][col] == true){
			return;
		}
		
		if(index == word.length() -1 && matrix[row][col].charAt(0) == word.charAt(index)){
			matchedWords.add(word);
			return;
		}
		
		if(matrix[row][col].charAt(0) !=  word.charAt(index)){
			return;
		}
		
		// if we reach here then the char matched and we have to explore our neighbours for next char
		visited[row][col] = true;
		findWord(matrix, word, index +1, row -1, col, visited, matchedWords);
		findWord(matrix, word, index +1, row , col -1, visited, matchedWords);
		findWord(matrix, word, index +1, row + 1, col, visited, matchedWords);
		findWord(matrix, word, index +1, row , col + 1, visited, matchedWords);
		
	}
	
	//Diagonal travarsal
	public static ArrayList<String> getAllMatchesDiagonal(String[][] matrix, String[] words){
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		ArrayList<String> matchedWords = new ArrayList<>();
		for (String word : words) {
			boolean[][] visited = new boolean[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					findWord2(matrix, word, 0, i, j, visited, matchedWords);
				}
			}
			
		}
		return matchedWords;
	}
	
	private static void findWord2(String[][] matrix, String word, int index, int row, int col, boolean[][] visited, ArrayList<String> matchedWords){
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		if(row < 0 || col < 0 || row >= maxRow || col >= maxCol ){
			return;
		}
		
		if(visited[row][col] == true){
			return;
		}
		
		if(index == word.length() -1 && matrix[row][col].charAt(0) == word.charAt(index)){
			matchedWords.add(word);
			return;
		}
		
		if(matrix[row][col].charAt(0) !=  word.charAt(index)){
			return;
		}
		
		// if we reach here then the char matched and we have to explore our neighbours for next char
		visited[row][col] = true;
		findWord2(matrix, word, index +1, row -1, col, visited, matchedWords);
		findWord2(matrix, word, index +1, row , col -1, visited, matchedWords);
		findWord2(matrix, word, index +1, row + 1, col, visited, matchedWords);
		findWord2(matrix, word, index +1, row , col + 1, visited, matchedWords);
		
		findWord2(matrix, word, index +1, row -1, col+1, visited, matchedWords);
		findWord2(matrix, word, index +1, row +1 , col -1, visited, matchedWords);
		findWord2(matrix, word, index +1, row -1,col-1, visited, matchedWords);
		findWord2(matrix, word, index +1, row+1 , col + 1, visited, matchedWords);
		
	}
	
}
