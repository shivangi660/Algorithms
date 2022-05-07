enum Status{
        GOOD, BAD, UNKNOWN;
    }
class Solution {
    int[] nums;
    public boolean canJump(int[] nums) {
        // Here the idea of travesing the array from end rather than starting is a good technique.
        // Backtracking
        this.nums= nums;
        //return canJumpHelperBF(0);
        
        // Top Down DP is if I can store at each index if the idx is good or bad or not yet determined, I can save some calls;
        // declare enum outside the class
        // create array of enum;
        
            
        //Status[] subResult = new Status[nums.length];
        //Arrays.fill(subResult, Status.UNKNOWN);
        // last index is good
        //subResult[nums.length - 1] = Status.GOOD;
        //Status s = canJumpTopDown(subResult, 0);
        //return s == Status.GOOD ? true : false;
        
        
        // Bottom Up Solution
        Status[] subResult = new Status[nums.length];
        Arrays.fill(subResult, Status.UNKNOWN);
        // last index is good
        subResult[nums.length - 1] = Status.GOOD;
        return canJumpBottomUp(subResult);
    }
    
    
    public boolean canJumpBottomUp(Status[] subResult){
        
        for(int i = nums.length - 2; i >= 0; i--){
            int possibleJumps = Math.min(i + nums[i], nums.length - 1);
            for(int j = i + 1; j <= possibleJumps; j++){
            if(subResult[j] == Status.GOOD){
                subResult[i] = Status.GOOD;
                break;
                }
            }
        }
        return subResult[0] == Status.GOOD;
        }
    
    
    public Status canJumpTopDown(Status[] subResult, int pos){
        if(subResult[pos] == Status.GOOD)
            return Status.GOOD;
        
        int jumps = Math.min(nums[pos] + pos, nums.length - 1);
        for(int i = pos + 1; i <= jumps; i++){
            if(canJumpTopDown(subResult,i) == Status.GOOD)
                return Status.GOOD;
            }
        subResult[pos] = Status.BAD;
        return Status.BAD;
    }
    
    
    
    public boolean canJumpHelperBF(int pos){
        if(pos == nums.length - 1)
            return true;
        
        int jumpsPermitted = Math.min(pos + nums[pos], nums.length - 1);
        for(int i = pos + 1; i <= jumpsPermitted; i++){
            if(canJumpHelperBF(i))
                return true;
        }
        return false;
    }
    
    
}