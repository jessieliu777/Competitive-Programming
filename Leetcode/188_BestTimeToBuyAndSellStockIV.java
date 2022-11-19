class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][] = new int[k + 1][prices.length];
		for (int i = 1; i < dp.length; i++) {
			int maxDiff = -prices[0];
			for (int j = 1; j < dp[0].length; j++) {
                // maxDiff = max profit up til and including yesterday
				maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j - 1]);
                //prices[j] = sell price today
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
			}
		}
		return dp[k][prices.length - 1];
    }
}