class Solution {
    public int coinChange(int[] coins, int amount) {
        // let dp[i] = the minimum amount of coins to make up i
        int[] dp = new int[amount+1]; // from 0 to amount
        Arrays.fill(dp, amount+1); // the maximum amount of coins we can use
        dp[0] = 0;
        // for every 'sub amount' a
        for (int a = 0; a < amount+1; a++){
            for (int coin: coins){
                // if the coin value doesn't surpass the amount
                if (a-coin >= 0){
                    dp[a] = Math.min(dp[a], 1+dp[a-coin]);
                }
            }
        }
        return dp[amount] <= amount? dp[amount] : -1;
    }
}