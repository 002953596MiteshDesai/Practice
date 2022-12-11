package com.AquaTurtle;

public class NumberOfWaysToReachObstacle {
	// time complexity O(m*n)
	
	// space O(1)
	public static int numWaysToReachEndWithObstacles(int[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		if(matrix[0][0] == Integer.MIN_VALUE){
			return 0;
		}
		matrix[0][0] = 1;
		// Initialize the first row and first col
		for(int i = 1 ; i < rows;i ++){
			if(matrix[i][0] == Integer.MIN_VALUE){
				continue;
			}
			matrix[i][0] = matrix[i-1][0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1;
		}
		for(int i = 1 ; i < cols;i ++){
			if(matrix[0][i] == Integer.MIN_VALUE){
				continue;
			}
			matrix[0][i] = matrix[0][i-1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1;
		}
		
		for(int i = 1; i < rows; i ++){
			for(int j = 1; j < cols; j ++){
				if(matrix[i][j] == Integer.MIN_VALUE){
					continue;
				}
				if(matrix[i-1][j] == Integer.MIN_VALUE){
					matrix[i][j] = matrix[i][j-1];
				}
				else if (matrix[i][j-1] == Integer.MIN_VALUE){
					matrix[i][j] = matrix[i-1][j];
				}else{
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
				}
			}
		}
		return matrix[rows-1][cols-1];
	}
	
	//Leetcode Solution
	
	//Space O( M X N ) Size of Matrix M X N
	//Space O(1)
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		int R = obstacleGrid.length;
		int C = obstacleGrid[0].length;
		
		// If the starting cell has an obstacle, then simply return as there would be
		// no paths to the destination.
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		
		// Number of ways of reaching the starting cell = 1.
		obstacleGrid[0][0] = 1;
		
		// Filling the values for the first column
		for (int i = 1; i < R; i++) {
			obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
		}
		
		// Filling the values for the first row
		for (int i = 1; i < C; i++) {
			obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
		}
		
		// Starting from cell(1,1) fill up the values
		// No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
		// i.e. From above and left.
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (obstacleGrid[i][j] == 0) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				} else {
					obstacleGrid[i][j] = 0;
				}
			}
		}
		
		// Return value stored in rightmost bottommost cell. That is the destination.
		return obstacleGrid[R - 1][C - 1];
	}
}

