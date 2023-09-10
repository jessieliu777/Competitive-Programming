class Solution {
    // The recursive solution is very slow, because its runtime is exponential

    // The original problem statement is equivalent to:
    // Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target

    // Let P be the positive subset and N be the negative subset
    // For example:
    // Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
    // Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]

    // Then let's see how this can be converted to a subset sum problem:

    //                 sum(P) - sum(N) = target
    // sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    //                     2 * sum(P) = target + sum(nums)
    // So the original problem has been converted to a subset sum problem as follows:
    // Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2

    // Note that the above formula has proved that target + sum(nums) must be even
    // We can use that fact to quickly identify inputs that do not have a solution

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;
        // if sum isn't enough to reach target or target + sum(nums) isn't even then there's no sol
        // otherwise try to find solution = number of subsets P such that sum(P) = (target + sum(nums)) / 2
        return sum < Math.abs(target) || (target + sum) % 2 > 0 ? 0 : subsetSum(nums, (target + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1]; // dp[i] = number of subsets P such that sum(P) = i
        dp[0] = 1;
        // for every num, iterate i from target to num inclusive. 
        // dp[i] = number of subsets P such that sum(P) = i = number of subsets where P includes num + number of subsets where P doesn't include num (prev iteration)
        // <=> number of subsets of {num} * number of subsets P such that sum(P) = i-num  + dp[i] (prev iteration)
        // <=> 1 * dp[i-n] + dp[i] = dp[i] dp[i-n]
        for (int n : nums) for (int i = target; i >= n; i--) dp[i] += dp[i - n]; 
        return dp[target];
    } 
}