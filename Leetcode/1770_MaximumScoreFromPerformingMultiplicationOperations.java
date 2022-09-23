class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[] dp = new int[multipliers.length+1];
        // for every start from right to left in multipliers
        for (int i = multipliers.length-1; i >= 0; i--){
            int[] dp_old = dp.clone();
            // for every end from left to right
            for (int j = i; j >= 0; j--){
                int resultLeft = multipliers[i] * nums[j] + dp_old[j+1];
                int resultRight = multipliers[i] * nums[nums.length-1-(i-j)] + dp_old[j];
                dp[j] = Math.max(resultLeft, resultRight);
            }
        }
        return dp[0];
    }

}