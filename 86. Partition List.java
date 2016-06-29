/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        
        // Create dummy nodes
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        
        // Initialize pointers
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        
        while(head != null){
            // Add nodes to leftDummy and rightDummy
            if(head.val < x){
                left.next = head;
                left = head;
            }else{
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        
        // Merge two lists
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}