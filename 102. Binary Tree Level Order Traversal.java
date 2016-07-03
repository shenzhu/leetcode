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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        
        if(root == null) return traversal;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);      // add root to queue
        
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
        
            int size = queue.size();        // record size of this level
            
            // Add all nodes in this level to level
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            traversal.add(level);
        }
        
        return traversal;
    }
}