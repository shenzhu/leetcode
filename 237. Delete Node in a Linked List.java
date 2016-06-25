/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Time: O(1)
public class Solution{
	public void deleteNode(ListNode node){
		// move next node to current 
		node.val = node.next.val;
		node.next = node.next.next;
	}
}