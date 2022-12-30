class Solution {
    public boolean isScramble(String s1, String s2) {
        // given s1, s2 same length, so no need for 2 vars
        int len = s1.length();
        // base case: if s1 is one char
        if (len == 1) return s1.equals(s2);
        
        // otherwise, for every division, check if 
        /**
		 * Let dp[i, j, k] = whether the substring of s2[j..j + k - 1] is a scrambled string of s1[i..i + k - 1] or not. i is the first index of s1, j is the first index of s2, and k is the length of string
		 * check for all possible 'cuts' q. Let q < k, then we for dp[i, j, k] to be true we just need one such cut to be true in the following situation:
		 * 
		 * S1 [   x1    |         x2         ]
		 *    i         i + q                i + k - 1
		 * 
		 * 2 possibilities for s2 if s2 is a scramble str of s2:
		 *      
		 * S2 [   y1    |         y2         ]
		 *    j         j + q                j + k - 1
		 *    
		 * or 
		 * 
		 * S2 [       y1        |     y2     ]
		 *    j                 j + k - q    j + k - 1
		 * 
		 * which means for some 1 <= q < k we have:
		 *  (dp[i, j, q] AND dp[i + q, j + q, k - q]) OR (dp[i, j + k - q, q] AND dp[i + q, j, k - q])
		 *  
		 * Base case is k = 1, where we simply need to check for S1[i] and S2[j] to be equal 
		 * */
        
        boolean[][][] dp = new boolean[len][len][len+1];
        // since index start at 0, so we move k down by. so dp[i][j][k] in code should be dp[i, j, k+1] from comments above
        for (int k = 1; k <= len; k++){
            for (int i = 0; i+k <= len; i++){
                for (int j = 0; j+k <= len; j++){
                    if (k == 1) dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    else for (int q = 1; q < k && !dp[i][j][k]; q++)
                        dp[i][j][k] = dp[i][j][q] && dp[i+q][j+q][k-q] 
                            || dp[i][j+k-q][q] && dp[i+q][j][k-q];                   
                }
            }
        }
        return dp[0][0][len];
    }
}