/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root){
        maxPathSumHelper(root);
        return ans;
    }
    
    public int maxPathSumHelper(TreeNode root) {
        if(root == null){
            return 0;
           }
        int left = Math.max(maxPathSumHelper(root.left), 0);
        int right = Math.max(maxPathSumHelper(root.right), 0);
        // either the node can have maximum value of the tree rooted at this node
        // or max value can be in left or right.
        ans = Math.max(root.val + left + right, ans);
        return root.val + Math.max(left, right);
    }
}