class Solution {
    int[] dp; // dp[i] = min xor from start to ith bit
    int[] nums1;
    int[] nums2;

    // We have a tight constraint here: n <= 14. Thus, we can just try all combinations.

    // For each position i in the first array, we'll try all elements in the second array that haven't been chosen before. We can use a bit mask to represent the chosen elements.

    // To avoid re-computing the same subproblem, we memoise the result for each bit mask.
    int dfs(int i, int mask) {
        // i = number of bits in mask, also cur index of nums1
        // stop when out of bounds
        if (i >= nums1.length) return 0;
        // if dp of cur digit hasn't been computed then do so
        if (dp[mask] == Integer.MAX_VALUE) 
            // go throug every potential num in nums2
            for (int j = 0; j < nums2.length; ++j)
                // if mask has the jth bit off, update dp[mask]; cur xor sum is xor of cur pair nums1[i], nums2[j] + sum of other pairs
                if ((mask & (1 << j)) == 0) dp[mask] = Math.min(dp[mask], (nums1[i] ^ nums2[j]) + dfs(i + 1, mask + (1 << j)));
        return dp[mask];
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        dp = new int[1 << nums2.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        this.nums1 = nums1;
        this.nums2 = nums2;
        // since digits <= 14, can try all combinations
        return dfs(0, 0);
    }
}