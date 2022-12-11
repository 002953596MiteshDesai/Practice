package com.AquaTurtle;

import java.util.*;

public class MergeIntervals {
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		
		ArrayList<Interval> merged = mergeIntervals(intervals);
		
		System.out.println("Hello world!");
	}
	
	
	public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return Integer.compare(o1.start, o2.start);
			}
		});
		
		Stack<Interval> stack = new Stack<>();
		stack.push(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval top = stack.peek();
			Interval current = intervals.get(i);
			if (top.end < current.start) {
				// they dont intersect
				stack.push(current);
			} else if (top.end < current.end) {
				top.end = current.end;
				stack.pop();
				stack.push(top);
			}
		}
		ArrayList<Interval> merged = new ArrayList<>();
		while (!stack.isEmpty()) {
			merged.add(0, stack.pop());
		}
		
		return merged;
	}
	
	//Leetcode Solution :
	
	// Complexity O(nlogn)
	
	public int[][] merge(int[][] intervals) {
		
		
		Arrays.sort(intervals, new MySort());
		List<int[]> ans = new ArrayList<>();
		ans.add(intervals[0]);
		int index = 0;
		
		for(int i=1;i<intervals.length;i++){
			if(intervals[i][0]<=ans.get(index)[1]){
				if(intervals[i][1]>ans.get(index)[1])
					ans.get(index)[1] = intervals[i][1];
				continue;
			}
			ans.add(intervals[i]);
			index++;
		}
		
		int arr[][] =  new int[ans.size()][2];  // list to int[][]
		for(int i=0; i<ans.size(); i++){
			arr[i][0] = ans.get(i)[0];
			arr[i][1] = ans.get(i)[1];
		}
		
		return arr;
	}
}

class MySort implements Comparator<int[]>{  //comparator
	public int compare(int[] a, int[] b){
		return a[0]-b[0];
	}
	
	
}

