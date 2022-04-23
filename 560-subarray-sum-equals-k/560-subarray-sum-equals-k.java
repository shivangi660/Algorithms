class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        // This line is important as it is taking care of the case when the subArray is starting from somewhere in middle of the array (eg when the array contains negative elements)
        map.put(0,1);
        for(int num : nums){
            sum = sum + num;
            // Need to search for sum - k; logic is sum = k which means sum - k = 0 or if already the same sum is occuring which means middle elements sum might have reduced and then incremented again. That means this is the case when the subarray will start from somewhere in middle.
            if(map.containsKey(sum - k)){
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}