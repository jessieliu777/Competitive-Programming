class Solution {
    public int minInsertions(String s) {
        // Split the string s into to two parts,
        // and we try to make them symmetrical by adding letters.

        // The more common symmetrical subsequence they have,
        // the less letters we need to add.

        // Now we change the problem to find the length of longest common sequence.
        // This is a typical dp problem.
        int len = s.length();
        // dp[i][j] means the length of longest common sequence between
        // i first letters in s and j first letters in s.reverse().
        int[][] dp = new int[len+1][len+1];
        for (int i = 0; i < len; i++) for (int j = 0; j < len; j++)
            dp[i + 1][j + 1] = s.charAt(i) == s.charAt(len - 1 - j) ? dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
        // min insertions = total length of s - len of longest common seq of s and s.reverse()
        // for ex s = mbadm, s.reverse9) = mdabm. longest common seq is mam, chars = 3. s.len() = 5, so we need to add 2 more chars to orig to make palindrome.
        return len - dp[len][len];
    }
}