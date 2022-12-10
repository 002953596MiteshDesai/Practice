package com.AquaTurtle;

//Time complexity : O(mn) We traverse the entire matrix once.
		
		// Space complexity : O(mn) Another matrix of the same size is used.


public class MinPathSum {
	
	private static int minimumPathSum(int[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] result = new int[rows][cols];
		result[0][0] = matrix[0][0];
		
		// Initialize the first row and first col
		for(int i = 1 ; i < rows;i ++){
			result[i][0] = matrix[i][0] + result[i-1][0];
		}
		for(int i = 1 ; i < cols;i ++){
			result[0][i] = matrix[0][i] + result[0][i-1];
		}
		
		for(int row = 1 ; row < rows; row ++) {
			for(int col = 1 ; col < cols; col ++) {
				result[row][col] = matrix[row][col] + Math.min(result[row-1][col],result[row][col -1] );
			}
		}
		
		return result[rows-1][cols-1];
		
	}
	
}
