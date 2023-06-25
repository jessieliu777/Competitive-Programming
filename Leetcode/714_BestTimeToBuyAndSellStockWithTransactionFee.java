class Solution {
  public int maxProfit(int[] prices, int fee) {
      long curMaxProfitWith0Stock = 0, curMaxProfitWith1Stock = Integer.MIN_VALUE; // make sure we have 'nothing to sell' at day 1 before buying any stocks
  
      for (int price : prices) {
          long pre = curMaxProfitWith0Stock;
          // cur max profit with 0 stock is max profit if we were to sell a stock today (resulting profit of cur max profit from pre day + price we just sold - transaction fee)
          curMaxProfitWith0Stock = Math.max(curMaxProfitWith0Stock, curMaxProfitWith1Stock + price - fee);
          // cur max profit with 1 stock is max profit if we were to buy a stock today (results in 1 stock as given pre has 0 stocks left)
          curMaxProfitWith1Stock = Math.max(curMaxProfitWith1Stock, pre - price);
      }
      // clearly less profit if we buy an extra stock, so return the result with 0 stock left
      return (int) curMaxProfitWith0Stock;
  }
}