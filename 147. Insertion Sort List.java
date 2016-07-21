/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;       // corner case
        
        ListNode dummyNode = new ListNode(0);       // dummyNode
        
        ListNode prev = dummyNode;
        ListNode curr = head;           // node to insert
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            
            // Find the right place to insert
            while(prev.next != null && prev.next.val < curr.val){
                prev = prev.next;
            }
            
            // Insert between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;
            prev = dummyNode;
            curr = next;
        }
        
        return dummyNode.next;
    }
}