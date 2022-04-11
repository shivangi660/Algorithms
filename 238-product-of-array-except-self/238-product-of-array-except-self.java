class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //1. Prefix Sum
        //2. Concept of Prefix Sum is keep computing some value while moving in the loop.
        // 3. If the value satisfies some condition then all the middle elements sum was 0. eg question is find subarray with sum = k. in this question we keep computing the sum and store in the hashMap. When sum - k is encountered again, that means the middle elements sum to k
        // 4. for this question, have the prefix sum stored in an extra ans array.
        
        int[] ans = new int[nums.length];
        ans[0] = 1;
        
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        
        int R = 1;
        for(int j = nums.length - 1; j >= 0; j--){
            ans[j] = ans[j] * R;
            R = R * nums[j];
        }
            
        return ans;
        
    }
}