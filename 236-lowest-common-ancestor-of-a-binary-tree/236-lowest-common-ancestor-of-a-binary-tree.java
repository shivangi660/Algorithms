/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorHelper(root, p ,q);
        return ans;
    }
    
    public boolean lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;
        int left = lowestCommonAncestorHelper(root.left, p ,q) ? 1 : 0;
        int right = lowestCommonAncestorHelper(root.right, p ,q) ? 1 : 0;
        int mid = (root == p || root == q)  ? 1 : 0;
        if(left + right + mid >= 2){
            ans = root;
        }
        return (left + right + mid > 0);
    }
}