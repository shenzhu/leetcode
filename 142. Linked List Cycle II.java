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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow;
        ListNode fast;

        // Initialize pointers
        slow = head;
        fast = head.next;

        while(fast != slow){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        while(head != slow.next){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}