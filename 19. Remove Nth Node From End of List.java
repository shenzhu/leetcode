/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode, fast = dummyNode;

        // Move fast in front so that the gap between slow and fast becomes n
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        // Move fast to the end, maintaining the gap
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummyNode.next;
    }
}