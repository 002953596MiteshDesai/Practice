package com.AquaTurtle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Horizontal & Vertical travarsal
// Complexity O(n3)
public class WordSearch2 {
	private static ArrayList<String> getAllMatches(String[][] matrix, String[] words) {
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
	
	private static void findWord(String[][] matrix, String word, int index, int row, int col, boolean[][] visited, ArrayList<String> matchedWords) {
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		if (row < 0 || col < 0 || row >= maxRow || col >= maxCol) {
			return;
		}
		
		if (visited[row][col] == true) {
			return;
		}
		
		if (index == word.length() - 1 && matrix[row][col].charAt(0) == word.charAt(index)) {
			matchedWords.add(word);
			return;
		}
		
		if (matrix[row][col].charAt(0) != word.charAt(index)) {
			return;
		}
		
		// if we reach here then the char matched and we have to explore our neighbours for next char
		visited[row][col] = true;
		findWord(matrix, word, index + 1, row - 1, col, visited, matchedWords);
		findWord(matrix, word, index + 1, row, col - 1, visited, matchedWords);
		findWord(matrix, word, index + 1, row + 1, col, visited, matchedWords);
		findWord(matrix, word, index + 1, row, col + 1, visited, matchedWords);
		
	}
	
	//Diagonal travarsal
	public static ArrayList<String> getAllMatchesDiagonal(String[][] matrix, String[] words) {
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
	
	private static void findWord2(String[][] matrix, String word, int index, int row, int col, boolean[][] visited, ArrayList<String> matchedWords) {
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		if (row < 0 || col < 0 || row >= maxRow || col >= maxCol) {
			return;
		}
		
		if (visited[row][col] == true) {
			return;
		}
		
		if (index == word.length() - 1 && matrix[row][col].charAt(0) == word.charAt(index)) {
			matchedWords.add(word);
			return;
		}
		
		if (matrix[row][col].charAt(0) != word.charAt(index)) {
			return;
		}
		
		// if we reach here then the char matched and we have to explore our neighbours for next char
		visited[row][col] = true;
		findWord2(matrix, word, index + 1, row - 1, col, visited, matchedWords);
		findWord2(matrix, word, index + 1, row, col - 1, visited, matchedWords);
		findWord2(matrix, word, index + 1, row + 1, col, visited, matchedWords);
		findWord2(matrix, word, index + 1, row, col + 1, visited, matchedWords);
		
		findWord2(matrix, word, index + 1, row - 1, col + 1, visited, matchedWords);
		findWord2(matrix, word, index + 1, row + 1, col - 1, visited, matchedWords);
		findWord2(matrix, word, index + 1, row - 1, col - 1, visited, matchedWords);
		findWord2(matrix, word, index + 1, row + 1, col + 1, visited, matchedWords);
		
	}
	
	//Leetcode Solution :
	//Time complexity: O(M(4⋅3L−1)) M - Number of cells , N Max length of word
	//Space O(n)
	
	class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		String word = null;
		
		public TrieNode() {
		}
	}
	
	class Solution {
		char[][] _board = null;
		ArrayList<String> _result = new ArrayList<String>();
		
		public List<String> findWords(char[][] board, String[] words) {
			
			// Step 1). Construct the Trie
			TrieNode root = new TrieNode();
			for (String word : words) {
				TrieNode node = root;
				
				for (Character letter : word.toCharArray()) {
					if (node.children.containsKey(letter)) {
						node = node.children.get(letter);
					} else {
						TrieNode newNode = new TrieNode();
						node.children.put(letter, newNode);
						node = newNode;
					}
				}
				node.word = word;  // store words in Trie
			}
			
			this._board = board;
			// Step 2). Backtracking starting for each cell in the board
			for (int row = 0; row < board.length; ++row) {
				for (int col = 0; col < board[row].length; ++col) {
					if (root.children.containsKey(board[row][col])) {
						backtracking(row, col, root);
					}
				}
			}
			
			return this._result;
		}
		
		private void backtracking(int row, int col, TrieNode parent) {
			Character letter = this._board[row][col];
			TrieNode currNode = parent.children.get(letter);
			
			// check if there is any match
			if (currNode.word != null) {
				this._result.add(currNode.word);
				currNode.word = null;
			}
			
			// mark the current letter before the EXPLORATION
			this._board[row][col] = '#';
			
			// explore neighbor cells in around-clock directions: up, right, down, left
			int[] rowOffset = {-1, 0, 1, 0};
			int[] colOffset = {0, 1, 0, -1};
			for (int i = 0; i < 4; ++i) {
				int newRow = row + rowOffset[i];
				int newCol = col + colOffset[i];
				if (newRow < 0 || newRow >= this._board.length || newCol < 0
						|| newCol >= this._board[0].length) {
					continue;
				}
				if (currNode.children.containsKey(this._board[newRow][newCol])) {
					backtracking(newRow, newCol, currNode);
				}
			}
			
			// End of EXPLORATION, restore the original letter in the board.
			this._board[row][col] = letter;
			
			// Optimization: incrementally remove the leaf nodes
			if (currNode.children.isEmpty()) {
				parent.children.remove(letter);
			}
		}
	}
	
	
}
