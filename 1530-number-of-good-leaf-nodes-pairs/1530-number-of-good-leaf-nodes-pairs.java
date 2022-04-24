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
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        countPairsHelper(root, distance);
        return count;
    }
    
    public HashMap<TreeNode, Integer> countPairsHelper(TreeNode node, int distance){
        if(node == null)
            return new HashMap<>();
        if(node.left == null && node.right == null){
            HashMap<TreeNode, Integer> map = new HashMap<>();
            map.put(node, 1);
            return map;
        }
        
        HashMap<TreeNode, Integer> left = countPairsHelper(node.left, distance);
        HashMap<TreeNode, Integer> right = countPairsHelper(node.right, distance);
        countGoodPairs(left, right, distance);
        HashMap<TreeNode, Integer> updatedMap = updateDistance(left, right);
        return updatedMap;
    }
    
    public void countGoodPairs(HashMap<TreeNode, Integer> left, HashMap<TreeNode, Integer> right, int d){
        for(TreeNode n : left.keySet()){
            int distance = left.get(n);
            for(int a : right.values()){
                if(Math.abs(a + distance) <= d){
                    count = count+1;
                }
            }
        }
    }
    
    public HashMap<TreeNode, Integer> updateDistance(HashMap<TreeNode, Integer> left, HashMap<TreeNode, Integer> right){
        HashMap<TreeNode, Integer> newMap = new HashMap<>();
        for(TreeNode n : left.keySet()){
            newMap.put(n, left.get(n) + 1);
        }
        for(TreeNode n : right.keySet()){
            newMap.put(n, right.get(n) + 1);
        }
        return newMap;
    }
}