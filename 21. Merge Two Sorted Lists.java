/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Corner case
        if(l1 == null && l2 == null) return null;
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        
        // Initialize pointers
        ListNode dummyNode = new ListNode(0);
        ListNode pointer = dummyNode;
        
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                pointer.next = l2;
                pointer = pointer.next;
                l2 = l2.next;
            }else{
                pointer.next = l1;
                pointer = pointer.next;
                l1 = l1.next;
            }
        }
        
        // Check which list is empty
        if(l1 == null){
            while(l2 != null){
                pointer.next = l2;
                pointer = pointer.next;
                l2 = l2.next;
            }
        }else{
            while(l1 != null){
                pointer.next = l1;
                pointer = pointer.next;
                l1 = l1.next;
            }
        }
        
        return dummyNode.next;
    }
}