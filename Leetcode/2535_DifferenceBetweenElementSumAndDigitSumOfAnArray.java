class Solution {
    public int differenceOfSum(int[] nums) {
        int result = 0;
        // given num is at most 4 digits, result for each num is num - (1000s digit + 100s digit + 10s digit + 1s digit)
        for(int num : nums) result += num - (num / 1000 + num / 100 % 10 + num % 100 / 10 + num % 10);
        return Math.abs(result);
    }
}