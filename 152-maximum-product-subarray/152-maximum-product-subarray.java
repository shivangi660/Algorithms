class Solution {
    public int maxProduct(int[] nums) {
        
        // The maxProduct will either start from 0 or it will end at n-1
        // So catch is to compute prefix and the suffix sum and check the max value.
        
        // int prefix = 0, suffix = 0, ans = nums[0];
        // for(int i = 0; i < nums.length; i++){
        //     prefix = (prefix == 0 ? 1 : prefix) * nums[i];
        //     suffix = (suffix == 0 ? 1 : suffix) * nums[nums.length - 1 - i];
        //     ans = Math.max(ans, Math.max(prefix, suffix));
        // }
        // return ans;
        
        // Other solution is to have min and max and interchange it whenever a negative value is encountered.
        
        
        
        int min = nums[0], max = nums[0], ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = min;
                min = max;
                max = temp;
            }
            
            min = Math.min(min*nums[i], nums[i]);
            max = Math.max(max*nums[i], nums[i]);
            ans = Math.max(ans, max);
            
        }
        return ans;
        
    }
    
}