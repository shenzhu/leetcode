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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        findTreePaths(root, result, sb);
        return result;
    }
    
    private void findTreePaths(TreeNode root, List<String> result, StringBuilder sb){
        if(root == null) return;
        
        int length = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            result.add(sb.toString());
        }else{
            sb.append("->");
            findTreePaths(root.left, result, sb);
            findTreePaths(root.right, result, sb);
        }
        sb.setLength(length);       // don't forget to remove element
    }
}