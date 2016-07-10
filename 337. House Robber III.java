/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Naive solution
public class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;

        int val = 0;

        // Rob current root
        if(root.left != null){
            val += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}


// Think one step further
public class Solution {
    public int robSub(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        
        int val = 0;
        
        // Do not rub current node
        if(root.left != null){
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }
        if(root.right != null){
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }
        
        val = Math.max(root.val + val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);
        
        return val;
    }
    
    public int rob(TreeNode root) {
        if(root == null) return 0;
        
        Map<TreeNode, Integer> map = new HashMap<>();
        return robSub(root, map);
    }
}


// Think one step back
public class Solution{
    public int rob(TreeNode root){
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robSub(TreeNode root){
        if(root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1])
        result[1] = root.val + left[0] + right[0];

        return result;
    }
}