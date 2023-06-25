class Solution {
    Set<String> set;
    
    public int minExtraChar(String s, String[] dictionary) {
        // add dict into set
        set = new HashSet<>();
        for (String word: dictionary) set.add(word);
        int len = s.length();
        int[] dp = new int[len+1]; // dp[j] = min num of extra chars left if we break up s[j..i] optimally where i is the cur iteration

        for (int i = 1; i <= len; i++) {
            // initialize to be the worst case which we skip the cur char 
            dp[i] = dp[i - 1] + 1;

            // let start = i-1 to 0, end = i
            for (int j = i - 1; j >= 0; j--) {
                // if the substr from j to i is in dict, then update min char left.
                String substring = s.substring(j, i);
                // optimal is either the cut where i get skipped (initialized via dp[i-1] + 1) or i isn't skipped so so extra chars in cur iter is +0, => dp[i] same as some dp[j] from j = 0 to i-1, which is what the loop is going thru
                if (set.contains(substring)) dp[i] = Math.min(dp[i], dp[j]);
            }
        }
        return dp[len];
        
    }
}