class Solution {
    public int maxProfit(int[] prices) {
        //The key point is we need to consider every peak immediately following a valley to maximize the profit. In case we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over one of the transactions leading to an overall lesser profit.
        
        // calculate peaks and valleys
        
        int i = 0;
        int maxProfit = 0;
        while(i < prices.length - 1){
            while(i+1 < prices.length && prices[i+1] <= prices[i]){
                i++;
            }
            int peak = i;
            while(i+1 < prices.length && prices[i+1] >= prices[i]){
                i++;
            }
            int valey = i;
            maxProfit = maxProfit + prices[valey] - prices[peak];
        }
       return maxProfit; 
    }
}