/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Version One: Iteration
public class Solution {
    public ListNode reverseList(ListNode head) {
        // Corner case
        if(head == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        return head;
    }
}

// Version Two: Recursion
public class Solution{
    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode rest = head.next;
        reverseList(rest);

        head.next.next = head;
        head.next = null;
        head = rest;
        return head;
    }
}