/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;  
        ListNode fast = head;  
        while(fast != null && fast.next != null){  
            slow = slow.next;  
            fast = fast.next.next;  
            if(slow == fast)  
                break;  
        }  
        if(fast == null || fast.next == null)  
            return false;  
        return true;
    }
}