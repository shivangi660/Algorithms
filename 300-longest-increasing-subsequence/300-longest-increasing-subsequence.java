class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        
        // ans array will have the length of the subsequence ending at i
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    ans[i] = Math.max(1 + ans[j], ans[i]);
                }
            }
        }
        int longest = 0;
        for(int c : ans){
            longest = Math.max(c, longest);
        }
        return longest;
    }
}