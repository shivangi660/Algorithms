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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        
        sumNumbersHelper(root, root.val);
        return sum;
        
    }
    
    public void sumNumbersHelper(TreeNode node, int digit){
        if(node.left == null && node.right == null){
            sum = sum + digit;
        }
        if(node.left != null){
            sumNumbersHelper(node.left,10 * digit + node.left.val);
        }
        if(node.right != null){
            sumNumbersHelper(node.right, 10 * digit + node.right.val);
        }
    }
    
}