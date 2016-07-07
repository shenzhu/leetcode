/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildBST(ListNode start, ListNode end){
        if(start == end) return null;
        
        // Initialize fast/slow runners
        ListNode slow = start;
        ListNode fast = start;
        
        // Find middle node
        while(fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Construct BST
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(start, slow);
        root.right = buildBST(slow.next, end);
        
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        
        return buildBST(head, null);
    }
}