class Solution {
    public int longestArithSeqLength(int[] nums) {
        // dp[index][diff] equals to the length of arithmetic sequence at index with difference diff.
        int res = 2, len = nums.length;
        HashMap<Integer, Integer> [] dp = new HashMap[len];
        // for every num end
        for (int end = 0; end < len; end++) {
            dp[end] = new HashMap<>();
            // for every num that's a start of subseq from it to end
            for (int start = 0; start < end; start++) {
                int diff = nums[end] - nums[start];
                // number of nums from 0 to end with difference diff is the number of nums with difference diff from 0 to start + 1 (init case, when start has no prev nums with diff, cur seq is just [start, end] so res = 2)
                dp[end].put(diff, dp[start].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[end].get(diff));
            }
        }
        return res;
    }
}