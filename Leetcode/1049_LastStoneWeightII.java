class Solution {
    public int lastStoneWeightII(int[] stones) {
        // Same problem as:
        // Divide all numbers into two groups,
        // what is the minimum difference between the sum of two groups?

        // Now it's a easy classic knapsack problem because:
        // One cancellation can be represented as one grouping.
        // One grouping can be represented as one knapsack partition.
        // If the grouping difference < max(stones), it can be realized by a cancellation.
        // With the 2 conclusions above,
        // we can know that the minimum result of cancellation is equal to minimum grouping difference,
        // which we solved by knapsack problem.

        // All cases of "cancellation of rocks" can be expressed by two knapsacks.
        // And the last stone value equals to the difference of these two knapsacks
        // It needs to be noticed that the opposite proposition is wrong.

        boolean[] dp = new boolean[1501]; // d[i] = true iff sum i is possible for the smaller group of the 2 knapsack. So we can only record the smaller one for less space cost, which less than half of the upper bound of given total sum 3000.
        dp[0] = true;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
            // for every potential sum from cur sum til stone
            for (int i = Math.min(1500, sum); i >= stone; --i)
            // the sum is possible if the sum - stone is possible using the stones to make that sum + cur stone
                dp[i] |= dp[i - stone];
        }
        // go through every potential sum from the smaller group, if it's possible then return the difference between the sum of it and the larger group. the larger group has sum - i, while this group has i, so difference is sum - i - i. Note the ans is minimal since we start the largest sum possible for the smaller group, which is bounded by 1500, half of 3000, so as we iterate the difference only gets bigger, hence the first possible sum has to be the smallest
        for (int i = sum / 2; i >= 0; --i) if (dp[i]) return sum - i - i;
        return 0;
    }
}