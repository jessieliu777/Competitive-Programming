class Solution {
    public int numSquares(int n) {
        // let dp[i] = min num of perfect squares that sums up to i
        int dp[]=new int[n+1];
        Arrays.fill(dp,n); // initialize to be n since n is a strict upper bound
        dp[0] = 0;
        dp[1] = 1;
        // for every i, try to add j^2
        for(int i=1;i<n+1;i++){
            for(int j=1;j<i+1;j++){
                // if i < j^2 then we can't add j^2
                int square=j*j;
                if(i-square<0){
                    break;
                }
                // otherwise update dp[i]
                else{
                    dp[i]=Math.min(dp[i],1+dp[i-square]);
                }
            }
        }
        return dp[n];
    }
}