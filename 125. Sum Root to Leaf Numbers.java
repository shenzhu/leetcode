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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    private int sum(TreeNode root, int result){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return result * 10 + root.val;
        return sum(root.left, result * 10 + root.val) + sum(root.right, result * 10 + root.val);
    }
}