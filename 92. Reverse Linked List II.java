/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m >= n) return head;
        
        // Set dummyNode
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;
        
        ListNode nodeBeforeM;
        ListNode nodeAtM;
        ListNode nodeAtN;
        ListNode nodeAfterN;
        
        // Find ListNode at position m - 1 and m
        for(int i = 0; i < m - 1; i++){
            if(head == null) return null;
            head = head.next;
        }
        
        nodeBeforeM = head;
        nodeAtM = head.next;
        nodeAtN = nodeAtM;
        nodeAfterN = nodeAtM.next;
        
        // Reverse Linked List from m to n
        for(int i = m; i < n; i++){
            if(nodeAfterN == null) return null;
            ListNode next = nodeAfterN.next;
            nodeAfterN.next = nodeAtN;
            nodeAtN = nodeAfterN;
            nodeAfterN = next;
        }
        
        // Set poitners at both sides
        nodeAtM.next = nodeAfterN;
        nodeBeforeM.next = nodeAtN;
        
        return dummyNode.next;
    }
}