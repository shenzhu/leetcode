/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse last half of linked list 
        slow.next = reverseList(slow.next);
        
        // Reorder one by one
        ListNode p1 = head;
        ListNode p2 = slow.next;
        
        //while(p1 != slow){
        while(p1 != null && p2 != null){
            slow.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p1.next.next;
            p2 = slow.next;
        }
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}