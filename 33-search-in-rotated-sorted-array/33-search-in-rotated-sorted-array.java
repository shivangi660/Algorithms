class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0, end = nums.length - 1;
        while(start <= end){
            // find middle element
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                return mid;
            }
            // check which side is rotated
            // means left side is not rotated
            else if(nums[start] <= nums[mid]){
                // check if element is there on left side
                if(target >= nums[start] && target < nums[mid]){
                    // element is on the left side
                    end = mid - 1;
                }
                else{
                    // element is on the right side
                    start = mid + 1;
                }
            }
            else{
                // right side is sorted
                // check if target is on the right side
                if(target > nums[mid] && target <= nums[end]){
                    // this means target is on the right side
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}