class Solution {
    public int maxProduct(int[] nums) {
        
        // This is valid when there is no 0 in the array
        // checked from constraints.
        // So that means prefix sum will either begin at 0 or end at n-1.
        
        int prefix = 0, suffix = 0, ans = nums[0];
        for(int i = 0; i < nums.length; i++){
            prefix = (prefix == 0 ? 1 : prefix) * nums[i];
            suffix = (suffix == 0 ? 1 : suffix) * nums[nums.length - 1 - i];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
        
        
        
    }
    
}