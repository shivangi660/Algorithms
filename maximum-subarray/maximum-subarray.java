class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], currentSum = nums[0];
        for(int i = 1;i < nums.length; i++){
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }
}