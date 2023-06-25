class Solution {
    public int getMaximumConsecutive(int[] coins) {
        // "Return the maximum number ... you can make with your coins starting from and including 0"
        // this equals to
        // "Return the minimum number that you can not make .."
        Arrays.sort(coins);
        int res = 1;
        for (int coin: coins) {
            // clearly if cur coin is greater than the next result target then we can't use it so we can't make the target. ()By iterations, prev coins are already used up so cur coin must be used)
            if (coin > res) break;
            // can skip res + 1 to res + coin - 1, since cur coin can be used for the coin part. So the next iteration of cur res + coin only needs to check if other coins is sufficient to make up the cur res part
            res += coin;
        }
        return res;
    }
}