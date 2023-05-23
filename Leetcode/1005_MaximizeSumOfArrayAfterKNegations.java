class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 1- sort the numbers in ascending order
        // 2- flip all the negative numbers, as long as k > 0
        // 3- find the sum of the new array (with flipped numbers if any) and keep track of the minimum number
        // 4- Now for the return statement

        // res is the total sum of the new array
        // K % 2 check if the remaining K is odd.

        // Because if it's even, it will have no effect
        // (we will flip a number and then get it back to the original)

        // If it's odd,
        // flip the minimum number and remove twice its value from the result
        // (twice because we already added it as positive in our sum operation)

        Arrays.sort(nums);
        for (int i = 0; k > 0 && i < nums.length && nums[i] < 0; i++, k--) nums[i] = -nums[i];
        int res = 0, min = 100; // given max num is 100
        for (int num : nums) {
            res += num;
            min = Math.min(min, num);
        }
        return res - (k % 2) * min * 2;
    }
}