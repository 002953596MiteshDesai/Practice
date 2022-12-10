package com.AquaTurtle;

//time Complexity O( M+N )
//space O(m X N)

public class SearchInMatrix {
	
	public static boolean searchInAMatrix(int[][] matrix, int target){
		int rows = matrix.length;
		int cols = matrix[0].length;
		int currentRow =  rows -1;
		int currentCol = 0;
		
		while(currentRow >= 0  && currentCol <= cols -1){
			if(matrix[currentRow][currentCol] == target){
				return true;
			}
			else if (matrix[currentRow][currentCol] < target){
				currentCol ++;
			}else{currentRow --;
			}
		}
		return false;
	}
}
