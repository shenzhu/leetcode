/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Version One
public class Solution{
    List<Integer> list = new ArrayList<Integer>();      // record values of nodes

    public void inOrderTraversal(TreeNode root){
        if(root == null) return;
        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }

    public boolean isValidBST(TreeNode root){
        // Corner case
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;

        inOrderTraversal(root);     // perform in-order traversal
        
        // Check if list is ascending order
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) <= list.get(i - 1)){
                return false;
            }
        }
        return true;
    }
}


// Version Two: Recursion, divide and conquer
public class Solution{
    // Keep the prevous value in inorder traversal
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root){
        // Traverse the tree inorder
        if(root != null){
            // Inorder traversal: left first
            if(!isValidBST(root.left)) return false;

            // Compare it with the previous value in inorder traversal
            if(pre != null && root.val <= pre.val) return false;
            pre = root;     // update the previous value

            // Inorder traversal: right last
            return isValidBST(root.right);
        }
        return true;
    }
}