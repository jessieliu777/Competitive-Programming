class Solution {
    public int deleteAndEarn(int[] nums) {
        // If we sort all the numbers into buckets indexed by these numbers, this is essentially asking you to repetitively take an bucket while giving up the 2 buckets next to it. (the range of these numbers is [1, 10000])

        // The optimal final result can be derived by keep updating 2 variables skip_i, take_i, which stands for:
        // skip_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you skip the ith bucket.
        // take_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you take the ith bucket.

        // DP formula:
        // take[i] = skip[i-1] + values[i];
        // skip[i] = Math.max(skip[i-1], take[i-1]);
        // take[i] can only be derived from: if you skipped the [i-1]th bucket, and you take bucket[i].
        // skip[i] through, can be derived from either take[i-1] or skip[i-1], whatever the bigger;

        int n = 10001; // given 1 <= num <= 10000
        int[] buckets = new int[n];
        for (int num : nums) buckets[num] += num;

        int maxTake = 0, maxSkip = 0;
        for (int i = 0; i < n; i++) {
            int takei = maxSkip + buckets[i]; // given to take the ith bucket we must've skipped the prev bucket (since if we took it then this bucket would've been gone') => so optimal for take have to be optimal from skipped (prev iter) + value of cur bucket
            int skipi = Math.max(maxSkip, maxTake); // skipping cur bucket means the max earning is just the max earning from prev iteration, which is either maxTake or maxSkip. 
            maxTake = takei;
            maxSkip = skipi;
        }
        return Math.max(maxTake, maxSkip);
    }
}