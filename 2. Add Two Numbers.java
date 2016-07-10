/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;       // corner case
        
        // Set dummyNode
        ListNode dummyNode = new ListNode(0);
        ListNode s = dummyNode;
        
        int sum = 0;
        while(l1 != null || l2 != null){
            sum /= 10;      // record carry
            
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            s.next = new ListNode(sum % 10);
            s = s.next;
        }
        
        // Check if there is carry in last digit
        if(sum / 10 == 1) s.next = new ListNode(1);
        return dummyNode.next;
    }
}