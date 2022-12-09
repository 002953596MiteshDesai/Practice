package com.AquaTurtle;

public class ContainerWithMostWater {
	
	// Complexity O(n)
	public int maxArea(int[] arr) {
		int maxArea = 0;
		int left = 0;
		int right = arr.length -1;
		int maxLeft = 0;
		int maxRight = arr.length -1;
		while(left < right){
			int area = Math.min(arr[left], arr[right]) * (right-left);
			if(maxArea < area){
				maxArea = area;
				maxLeft = left;
				maxRight = right;
			}
			if(arr[left] <= arr[right]){
				left ++;
			}else{
				right--;
			}
		}
		
		System.out.println("Left = " + maxLeft);
		System.out.println("Right = " + maxRight);
		
		
		return maxArea;
	}
}
