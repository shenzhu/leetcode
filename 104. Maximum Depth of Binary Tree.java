/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Divide and Conquer
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}

// Traverse
public class Solution {
    int max;
    void traverse(TreeNode root, int depth){
        if(root == null) return;
        if(depth > max) max = depth;

        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }

    public int maxDepth(TreeNode root) {
        max = 0;

        if(root == null){
            return 0;
        }

        traverse(root, 1);
        return max;
    }
}