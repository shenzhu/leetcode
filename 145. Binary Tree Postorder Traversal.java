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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorder = new ArrayList<Integer>();

        //check if root is null
        if(root == null){
            return postorder;
        }

        //divide
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);

        //conquer
        postorder.addAll(left);
        postorder.addAll(right);
        postorder.add(root.val);

        return postorder;
    }
}