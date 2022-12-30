class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        // dp[i] = most points assume the questions are starting from i to end
        long dp[] = new long[n + 1]; 
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int jump = questions[i][1];
            dp[i] = Math.max(points + dp[Math.min(jump + i + 1, n)], dp[i + 1]);
        }
        return dp[0];
    }
}