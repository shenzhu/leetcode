/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution{
	public TreeNode invertTree(TreeNode root){
		// Corner cases
		if(root == null){
			return null;
		}

		TreeNode temp = root.left;
		root.right = root.left;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
}