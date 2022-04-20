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
//subtract only while processing the root node in the inorder traversal and not while doing the recursive calls for the left and the right subtrees.
class Solution {
    int k ;
    int ans = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        KthSmallestHelper(root);
        return ans;
    }
    
    public void KthSmallestHelper(TreeNode node){
        if(node.left != null){
            KthSmallestHelper(node.left);
        }
        k--;
        if(k == 0){
            ans = node.val;
            return;
        }
        if(node.right != null)
            KthSmallestHelper(node.right);
    }
}