class Solution {
    public int maximizeGreatness(int[] nums) {
        // the answer is independent of the initial permutation i.e. nums itself. We are only concerned about the digits in it and their frequencies, not their relative initial order.
        // To get as many perm[i] > nums[i] as possible, starting from i = 0
        // If nums[0] is done, we then try nums[1] and so on.
        // So we can start with res = 0 and nums[res] is the next element to compare (since it's sorted)
        Arrays.sort(nums);
        int res = 0;
        // ex: nums = [1,3,5,2,1,3,1]
        // sorted = [1, 1, 1, 2, 3, 3, 5]
        // iter0, 1, 2: num = 1, 1 !> nums[res] = nums[0] = 1 => res = 0
        // iter3: num = 2, 2 > nums[res] = nums[0] = 1 => res = 1
        // iter4: num = 3, 3 > nums[res] = nums[1] = 1 => res = 2
        // iter5: num = 3, 3 > nums[res] = nums[2] = 1 => res = 3
        // iter6: num = 5, 5 > nums[res] = nums[3] = 2 => res = 4
        for (int num : nums) if (num > nums[res]) res++;
        return res;
    }
}