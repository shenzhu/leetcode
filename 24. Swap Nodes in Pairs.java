/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;      // corner case
        
        // Set dummyNode
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        
        ListNode prev = dummyNode;
        ListNode curr = head;
        
        while(curr != null && curr.next != null){
            ListNode next = curr.next;
            
            // Swap nodes
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            
            // Move pointers
            prev = curr;
            curr = curr.next;
        }
        
        return dummyNode.next;
    }
}
