package com.AquaTurtle;

//LeetCode Format Complexity O(n)
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
		
		ListNode result = null;
		
		if(node1 == null ){
			return node2;
		}
		if(node2 == null){
			return node1;
		}
		if(node1.val < node2.val){
			result = node1;
			result.next = mergeTwoLists(node1.next, node2);
		}else{
			result = node2;
			result.next = mergeTwoLists(node1, node2.next);
		}
		return result;
	}
}
