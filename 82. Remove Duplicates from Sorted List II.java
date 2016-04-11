/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //extreme situation
        if(head == null) return head;
        
        //construct dummy node
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummyNode;
        ListNode cur = head;
        
        while(cur != null){
            boolean duplicate = false;
            //jump over duplicate nodes
            while(cur.next != null && cur.val == cur.next.val){
                //set flag
                duplicate = true;
                cur = cur.next;
            }
            
            //delete last duplicated node
            if(duplicate){
                cur = cur.next;
                //deal with [1, 1, 2, 2, 3]
                continue;
            }
            
            //move pointers
            prev.next = cur;
            prev = cur;
            cur = cur.next;
        }
        
        //if cur == null, then cur is out of this list
        prev.next = cur;
        return dummyNode.next;
    }
}