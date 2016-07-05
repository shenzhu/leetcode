/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Method One: Inorder traverse(recursive)
public class Solution {
    ArrayList<Integer> result = new ArrayList<Integer>();

    public void inOrderBST(TreeNode root){
        if(root == null) return;
        
        inOrderBST(root.left);
        result.add(root.val);
        inOrderBST(root.right);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 1) return 0;
        
        inOrderBST(result);
        return result.get(k - 1);
    }
}


// Method Two: Inorder traverse(keep k--)
public class Solution{
    // better keep these two variables in a wrapper class
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    
    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
}

// Method Three: Inorder traverse(iterative)
public int kthSmallest(TreeNode root, int k){
    Stack<TreeNode> stack = new Stack<>();

    while(root != null){
        stack.push(root);
        root = root.left;
    }

    while(k != 0){
        TreeNode node = stack.pop();
        k--;

        if(k == 0) return node.val;

        TreeNode right = node.right;
        while(right != null){
            stack.push(right);
            right = right.left;
        }
    }

    return -1;
}
