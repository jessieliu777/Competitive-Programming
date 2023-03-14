class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        // Maximize Win From One Segments -> can be solved by sliding window.
        // With the max first seg, slide the second segment and get calculate the result from dp.

        // So we have the DP array that for each position keeps a value of the optimal interval that have been found before this position.
        // In parallel to that we are moving sliding window forward. And each sliding window interval we check if the sum of "the current interval" plus "the most optimal interval before current one" is bigger than the maximum. Update the maximum if needed.
        int res = 0, len = prizePositions.length, j = 0;
        int dp[] = new int[len + 1]; // dp[i] = optimal number of prizes from 0 to i if we pick one seg
        for (int i = 0; i < len; i++) {
            // find the first j that fits in the segment prizePositions[i]-k, prizePositions[i]
            while (prizePositions[j] < prizePositions[i] - k) j++;
            int prizesFromJtoIIncusive = i - j + 1; // by how we defined j, prizePosition at j won't exceed i so i-j+1 is always positive
            // means the optimal segment in subarray [0...i+1] is the better one of the following:
            // (1) taking the i+1th prize -> we have i - j + 1 prizes
            // (2) don't take the i+1th prize' -> we have dp[i] prizes
            dp[i + 1] = Math.max(dp[i], prizesFromJtoIIncusive); // the next optimal number of prizes if we pick 1 seg
            res = Math.max(res, prizesFromJtoIIncusive + dp[j]); // optimal so far = optimal from j to i + optimal from 0 to j
        }
        return res;
    }
}