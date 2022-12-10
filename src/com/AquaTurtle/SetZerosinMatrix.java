package com.AquaTurtle;

import java.util.HashSet;

//Time Complexity: O(M×N)O(M \times N)O(M×N) where M and N are the number of rows and columns respectively.
//
//Space Complexity: O(M+N)O(M + N)O(M+N).


public class SetZerosinMatrix {
	
	public void setZeroes(int[][] matrix) {
		HashSet<Integer> rowSet = new HashSet<>();
		HashSet<Integer> colSet = new HashSet<>();
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for(int i = 0 ; i < rows; i ++){
			for(int j = 0 ; j < cols; j ++){
				
				//Checking if element is 0
				if(matrix[i][j] == 0 ){
					if(!rowSet.contains(i)){
						rowSet.add(i) ;
					}
					if(!colSet.contains(j)){
						colSet.add(j) ;
					}
				}
			}
		}
		
		
		for(int i = 0 ; i < rows; i ++){
			for(int j = 0 ; j < cols; j ++){
				if(rowSet.contains(i) || colSet.contains(j)){
					matrix[i][j] = 0;
				}
			}
		}
		
	}
	
}



