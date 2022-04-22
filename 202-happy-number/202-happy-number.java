class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        
        while(n != 1 && !visited.contains(n)){
            visited.add(n);
            n = computeSum(n);
            
            
        }
        
        return n == 1;
    }
    
    public int computeSum(int number){
        int sum = 0;
        while(number > 0){
            int d = number % 10;
            number = number / 10;
            sum = sum + d*d;
        }
        return sum;
    }
}