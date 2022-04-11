class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store additional information of the number and the corresponding Index
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        for(int a : nums){
            map.put(a, i);
            i++;
        }
        
        int[] ans = new int[2];
        for(i = 0; i < nums.length; i++){
            int reqd = target - nums[i];
            
            // This is an edge case where the reqd in the map must not be the number itself.
            if(map.containsKey(reqd) && map.get(reqd) != i){
                ans[0] = i;
                ans[1] = map.get(reqd);
                break;
            }
        }
        return ans;
    }
}