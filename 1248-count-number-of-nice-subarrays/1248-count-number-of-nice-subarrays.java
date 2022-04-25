class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // continuous subarray;
        // Subarray sum equals k . Replace all even number with 0's and odd numbers with 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int num : nums){
            if(num % 2 == 0){
                nums[i] = 0;
            }
            else{
                nums[i] = 1;
            }
            i++;
        }
        map.put(0,1);
        int sum = 0, count = 0;
        for(int num : nums){
            sum = sum + num;
            if(map.containsKey(sum - k)){
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}