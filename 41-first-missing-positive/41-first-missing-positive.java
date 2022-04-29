class Solution {
    public int firstMissingPositive(int[] nums) {
        // check if 1 is there in the array
        boolean one  = false;
        for(int num : nums){
            if(num == 1){
                one = true;
                break;
            }
        }
        
        if(one == false){
            System.out.println("returning here");
            return 1;
        }
        
        // data cleanup - remove all 0's and -ive values and replace by 1
        for(int i = 0; i < nums.length; i++){
            if((nums[i] <= 0) || (nums[i] > nums.length)){
                    nums[i] = 1;
            }
        }
        
        // use Index as the key and store the result as +ive and -ive
        for(int i = 0 ;i < nums.length; i++){
            int idx = Math.abs(nums[i]);
            if(idx == nums.length){
                nums[0] = - Math.abs(nums[0]);
            }else{
                nums[idx] = - Math.abs(nums[idx]);
            }
        }
        for(int i = 1 ;i < nums.length; i++){
            if(nums[i] > 0){
                return i;
            }
        }
        if(nums[0] > 0){
            return nums.length;
        }
        return nums.length + 1;
    }
}