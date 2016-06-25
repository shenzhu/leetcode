/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Version One: Recursive
public class Solution{
	public boolean is isSameTree(TreeNode p, TreeNode q){
		// Corner cases
		if(p == null && q == null){
			return true;
		}else if(p == null || q == null){
			return false;
		}

		return ((p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}
}

// Version Two: Iterative
public class Solution{
	public boolean isSameTree(TreeNode p, TreeNode q){
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		q1.offer(p);
		q2.offer(q);

		while(!q1.isEmpty() && !q2.isEmpty()){
			TreeNode x = q1.poll();
			TreeNode y = q2.poll();

			if(((x == null) && (y != null)) || ((x != null) && (y == null))) return false;

			if(x.val != y.val) return false;

			q1.offer(x.left);
			q1.offer(x.right);
			q2.offer(y.left);
			q2.offer(y.right);
		}

		return true;
	}
}
