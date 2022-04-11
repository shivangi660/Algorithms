class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // 1 Solution : sort
        // 2 Solution : HashMap/Set
        
        Set<Integer> distinct = new HashSet<Integer>();
        for(int a : nums){
            if(distinct.contains(a)){
                return true;
            }
            else{
                distinct.add(a);
            }
        }
        return false;
    }
}