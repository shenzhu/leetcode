/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Method One
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    private void rightView(TreeNode root, List<Integer> result, int depth){
        if(root == null) return;
        if(depth == result.size()) result.add(root.val);
        
        rightView(root.right, result, depth + 1);
        rightView(root.left, result, depth + 1);
    }
}


// Method Two: Reverse level order traversal
public class Solution{
	public List<Integer> rightSideView(TreeNode root){
		// Reverse level traversal
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);
		while(queue.size() != 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode current = queue.poll();
				if(i == 0) result.add(current.val);
				if(current.right != null) queue.offer(current.right);
				if(current.left != null) queue.offer(current.left);
			}
		}

		return result;
	}
}