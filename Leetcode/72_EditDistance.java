class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length()-1;
        int n2=word2.length()-1;
        // dp[i][j] = min ops required to convert word1[0:i] to word2[0:j]
        int dp[][]=new int[n1+2][n2+2];
        // base case: if one string is empty, then the number of ops is the length of the other string
        for(int i=0;i<=n1+1;i++){
            for(int j=0;j<=n2+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=Math.max(i,j);
                }
                else{
                    break;
                }
            }
        }
        for(int i=1;i<=n1+1;i++){
            for(int j=1;j<=n2+1;j++){
                //if both characters are equal then keep the i-1 and j-1 value as result
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                //else add one to result and keep the best of dp[i-1][j-1], dp[i-1][j], dp[i][j-1] since all of them can reach dp[i][j] in one move
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[n1+1][n2+1];
    }
}