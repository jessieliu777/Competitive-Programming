class Solution {
    public boolean canPartition(int[] nums) {
        // if sum is odd then you can't divide it into 2 equal sum subsets
        int sum = IntStream.of(nums).sum();
        if ((sum & 1) == 1) return false;
        
        sum /= 2; // the sum for subset
        boolean[] dp = new boolean[sum+1]; 
        dp[0] = true; // placeholder base case
        
        // for every number dp[i] = true iff sum i can be achieved from the subset arr up til cur num 
        // so by the end of following iteration dp[sum] = true iff sum can be achieved from a subset of nums. This is sufficient given sum must be even when we get here and original sum = 2*sum. So once we found such subset the remaining subset must be the ones not in this subset, thus having one such subset guarentees 2
        // for arr = [1, 5, 11, 5]
        // dp[1] = true since [1] can have sum 1
        // dp[5] = true when sum = 6, and arr = [1, 5]
        for (int num : nums) {
            // for every possible sum from max subset sum to num
            for (int i = sum; i >= num; i--) {
                // if i-num is achievable sum from arr up til cur num, then since num <= i <= sum, is is also achievable by adding num to that subset
                // also if i is already achieved by some prev iteration's subset 'then it should remain achieved
                dp[i] = dp[i] || dp[i-num];
            }
        }
        
        return dp[sum];
    }
}