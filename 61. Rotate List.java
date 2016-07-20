/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;      // corner case
        
        // Set dummyNode
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        
        // Set pointers
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        
        // Find the length of list
        int l;
        for(l = 0; fast.next != null; l++){
            fast = fast.next;
        }
        
        // Set slow to the l - (k % l)the node
        for(int j = l - (k % l); j > 0; j--){
            slow = slow.next;
        }
        
        // Rotate list
        fast.next = dummyNode.next;
        dummyNode.next = slow.next;
        slow.next = null;
        
        return dummyNode.next;
    }
}