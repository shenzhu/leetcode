/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverse(ListNode head){
        if(head == null) return head;
        
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) slow = slow.next;      // make reversed list the longer one
        
        slow = reverse(slow);
        
        // Compare first half part and reversed part
        while(slow != null){
            if(slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}