class Solution {
    public int maxJump(int[] stones) {
        // Claim 1: It is optimal that we make use of all rocks: There is never a benefit of not including a rock in Path 1 or Path 2, it is always positive or neutral.

        // Claim 2: It is never optimal to choose two consecutive rocks: If we choose rock_i, and rock_i+1, then rock_i+2 will have to do (rock_i+2)-(rock_i) work to return on the way back. Because the array is strictly increasing, it holds that (rock_i+2)-(rock_i) > (rock_i+1-rock_i)

        // Therefore one path must lie on each even index and the other path must lie on each odd index. We iterate through them and find the maximum distance. Since absolute difference is same forward and backwards, we just need one loop to check every stone
        int res = stones[1] - stones[0], n = stones.length;
        for (int i = 2; i < n; i++) res = Math.max(res, stones[i] - stones[i-2]);
        return res;
    }
}