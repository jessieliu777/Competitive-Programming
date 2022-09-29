class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1]; // dp[i] = max sum from 0 to i
        // i = end
        for(int i=1;i<=n;i++){
            int maxInWindow=0;
            int maxSum=0;
            // j = start
            for(int j=1;j<=Math.min(i,k);j++){
                maxInWindow=Math.max(maxInWindow,arr[i-j]);
                maxSum=Math.max(dp[i-j]+maxInWindow*j,maxSum);
            }
            dp[i]=maxSum;
        }
        return dp[n];
    }
}
