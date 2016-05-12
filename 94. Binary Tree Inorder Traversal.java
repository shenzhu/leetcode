/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Traversal
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        traverse(root, inorder);
        return inorder;
    }

    public void traverse(TreeNode root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        traverse(root.left, inorder);
        inorder.add(root.val);
        traverse(root.right, inorder);
    }
}