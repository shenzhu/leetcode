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
    public List<TreeNode> generateTrees(int n) {
        return generateSubtrees(1, n);
    }
    
    private List<TreeNode> generateSubtrees(int start, int end){
        List<TreeNode> result = new LinkedList<TreeNode>();
        
        if(start > end){
            result.add(null);
            return result;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> leftSubtrees = generateSubtrees(start, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, end);
            
            for(TreeNode left : leftSubtrees){
                for(TreeNode right : rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}