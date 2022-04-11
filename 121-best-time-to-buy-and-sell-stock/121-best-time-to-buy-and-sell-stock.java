class Solution {
    public int maxProfit(int[] prices) {
        
        //Brute Force solution is to consider everyday as the buying day and iterate from the next day to find the maximum Profit 
        // But here complexity will be O(n^2).
        
        // Other solution is to think intutively and see that we are checking the min and the max value . So for every value there will be 2 cases:
        // 1. either it can be less than minimum. Update minimum. Now we want to see the max value from this day.
        // 2. The value will be greater than the minimum value and Update the max Profit if it exceeds already computed maximum Profit.
        
        // Here pattern is that we need to mantain positive value of the price.
        // Can be thought of as Implementation of Kadane's algorithm.
        
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            else if(profit < (prices[i] - minPrice)){
                profit = prices[i] - minPrice;
            }
        }
        
        return profit;
    }
}