package com.AquaTurtle;

public class NumberOfIslands {
	
	public static int findNumIslands(String[][] matrix) {
		int count = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] visited = new boolean[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j].equals("1") && visited[i][j] == false) {
					count++;
					visitNeighbours(matrix, visited, i, j);
				}
			}
		}
		
		return count;
	}
	
	private static void visitNeighbours(String[][] matrix, boolean[][] visited, int row, int col) {
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		
		if (row < 0 || col < 0 || row >= maxRow || col >= maxCol || matrix[row][col].equals("0") || visited[row][col] == true) {
			return;
		}
		visited[row][col] = true;
		visitNeighbours(matrix, visited, row - 1, col);
		visitNeighbours(matrix, visited, row, col - 1);
		visitNeighbours(matrix, visited, row, col + 1);
		visitNeighbours(matrix, visited, row + 1, col);
	}
	
	//Leetcode Solution
	// Complexity O(M X N )
	
	public int numIslands(char[][] grid) {
		if (grid.length == 0) return 0;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					search(grid, i, j);
				}
			}
		}
		return count;
	}
	
	private void search(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
			return;
		grid[i][j] = '0';
		search(grid, i + 1, j);
		search(grid, i - 1, j);
		search(grid, i, j + 1);
		search(grid, i, j - 1);
	}
}
