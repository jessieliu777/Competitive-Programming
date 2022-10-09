class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            // for all x, x^x = 0, so the non-zero result is the final result
            result ^= num;
        }
        return result;
    }
}