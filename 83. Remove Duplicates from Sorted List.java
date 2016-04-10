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
        //Attention: Always check extreme situation
        if(head == null){
            return head;
        }
        
        //singly-linked list, no going back, use a temp pointer
        ListNode pstart = head;
        
        while(pstart.next != null){
            //check duplicate
            if(pstart.val == pstart.next.val){
                //delete duplicate
                if(pstart.next.next == null){
                    pstart.next = null;
                    //[1, 2, 2]
                    break;
                }else{
                    pstart.next = pstart.next.next;
                    //[1, 1, 1]
                    continue;
                }
            }
            //move pointer
            pstart = pstart.next;
        }
        return head;
    }
}

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
        //Attention: Always check extreme situation
        if(head == null) return head;
        
        for(ListNode prev = head, cur = head.next; cur != null; cur = prev.next){
            //check duplicate
            if(prev.val == cur.val){
                //delete
                prev.next = cur.next;
            }else{
                //update pointers
                prev = cur;
            }
        }
        return head;
    }
}