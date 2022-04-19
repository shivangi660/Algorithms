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
    HashMap<Integer, Integer> map = new HashMap<>(); 
    int target;
   
    public int pathSum(TreeNode root, int targetSum) {
        // The mistake done was:
        //pathSumHelper(root.left,targetSum) + pathSumHelper(root.left, targetSum - value)
        //There was the miss that when in the recursive function the targetSum will be called, it won't be called with the targetSum value but will be called with the updated value.
        
        // ****** Right Recursive Solution Here will be ******
    
//         if(root == null){
//             return 0;
//         }
//         return pathSumHelper(root,targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
//     }
        
//         public int pathSumHelper(TreeNode node, int currentSum){
//             if(node == null){
//                 return 0;
//             }
//             return (currentSum == node.val ? 1 : 0) + pathSumHelper(node.left, currentSum - node.val) +                                                    pathSumHelper(node.right, currentSum - node.val);
//         }
        
        // This logic is for Prefix Sum
        // Whenever we have to check subArray, subMatrix or treePaths that sum to target we use prefix sum technique
        // For trees we have to either check th left or the right subtrees, hence we have to remove the last value from the subtree after processing the left and the right childs.
        target = targetSum;
        helper(root, 0);
        
        return count;
    }
    
    public void helper(TreeNode node, int currSum){
        if(node == null){
            return ;
        }
        
        currSum += node.val;
        
        if(currSum == target){
            count++;
        }
        
        count = count + map.getOrDefault((currSum - target), 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        helper(node.left, currSum);
        helper(node.right, currSum);
        
        map.put(currSum, map.get(currSum) - 1);
    }
}