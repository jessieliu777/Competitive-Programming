class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1]; // comb[i] = number of ways to add up to i
        comb[0] = 1; // 1 way to add up to 0 (nothing given all nums are positive)
        // go through every possible target from 1 to target
        for (int i = 1; i < comb.length; i++) {
            // go through every num in nums
            for (int j = 0; j < nums.length; j++) {
                // if we can use cur num as a combination (meaning cur num is at most i so we can possible add some other num to it to sum up to i), then the number of combination of i also contains the number of combination of i - cur num
                if (i - nums[j] >= 0) comb[i] += comb[i - nums[j]];
            }
        }
        return comb[target];
    }
}