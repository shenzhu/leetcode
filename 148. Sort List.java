/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution{
    ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return dummyNode.next;
    }
    
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        // Cut the list to two halves
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // Sort two halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // Merge two halves
        return merge(l1, l2);
    }
}