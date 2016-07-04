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
    public TreeNode buildTreeInPost(int preEnd, int inStart, int inEnd, int[] inorder, int[] postorder){
        if(preEnd < 0 || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[preEnd]);
        int inIndex = 0;        // index of root in postorder
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == root.val) inIndex = i;
        }
        root.left = buildTreeInPost(preEnd - (inEnd - inIndex) - 1, inStart, inIndex - 1, inorder, postorder);
        root.right = buildTreeInPost(preEnd - 1, inIndex + 1, inEnd, inorder, postorder);
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeInPost(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
}