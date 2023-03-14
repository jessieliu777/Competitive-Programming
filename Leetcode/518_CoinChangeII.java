class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // dp[i] = number of combinations that make up i amount using only the coins up til cur coin
        dp[0] = 1; // 1 way to make $0
        // for example amount = 5, coins = [1, 2, 5]
        // iteration 0: coin = 1
        // for i = 1 to 5, dp[i] += dp[i-1]
        // in this case i = 1 -> dp[1] += dp[0] = 1
        // i = 2 -> dp[i] += dp[1] = 1
        // ... and so on for all 5 i's, dp[i] = 1
        // this is as wanted since there is only 1 way to make up of any amount using only coin=1

        // iteration 1: coin = 2, coins=[1, 2]
        // for each amount i = 2 to 5 we want to add the number of ways to make up i using coins=[1, 2]
        // for i = 1 to 5, dp[i] += dp[i-2]
        // in this case i = 2 -> dp[2] += dp[0] = 1 (from iteration 0's dp[]2')+1(dp[0]) = 2
        // i = 3 -> dp[3] += dp[1] = 1 + 1 = 2
        // i = 4 -> dp[4] += dp[2] = 1 + 2 = 3
        // i = 5 -> dp[5] += dp[3] = 1 + 2 = 3
        for (int coin : coins) {
            // for every possible amount from coin amount to total amount
            for (int i = coin; i <= amount; i++) {
                // the number of combinations that make up i = the number of combinations that make up i without using cur coin + number of combinations that make up i using cur coin
                // = dp[i] (prev iteration) + number of combinations that make up coin using coin * number of combinations that make up i-coin 
                // = dp[i] (prev iteration) + 1 * dp[i-coin]
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}