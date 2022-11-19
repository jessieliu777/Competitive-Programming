class Solution {
    public int maxProfit(int[] prices) {
        int maximumProfit = 0;
        // for every day
        for(int i=1; i<prices.length; i++) {
            int diff = prices[i]-prices[i-1];
            // If the difference is positive value, then we should buy it
            if(diff > 0){
                maximumProfit += diff;
            }
        }
        return maximumProfit;
    }
}