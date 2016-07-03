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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        
        if(root == null) return traversal;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int currLevelNum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                
                // Add to level according to current level number
                if(currLevelNum % 2 == 0){
                    level.add(node.val);
                }else{
                    level.add(0, node.val);
                }
                
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            
            traversal.add(level);
            currLevelNum++;
        }
        return traversal;
    }
}