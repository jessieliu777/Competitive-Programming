class Solution {
    public int rotatedDigits(int n) {
        final int INVALID = 0;
        final int SAME = 1;
        final int DIFFERENT = 2;
        int[] dp = new int[n + 1];
        int count = 0;
        for (int i = 0; i <= n; i++){
            // single digit
            if (i < 10){
                // 0, 1, 8 => same
                if (i == 0 || i == 1 || i == 8) dp[i] = SAME;
                // 2, 5, 6, 9 => different
                else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = DIFFERENT;
                    count++;
                }
            } 
            // multiple digits
            else {
                // get the result of remainder and the rest of the digits
                int a = dp[i / 10], b = dp[i % 10];
                // if both are same then this num is also same
                if(a == 1 && b == 1) dp[i] = SAME;
                // if at least 1 is not the same, and they are both valid then this num is different
                else if(a >= 1 && b >= 1){
                    dp[i] = DIFFERENT;
                    count++;
                }
            }
        }
        return count;
    }
}