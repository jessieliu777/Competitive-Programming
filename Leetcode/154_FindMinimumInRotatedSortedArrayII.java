class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int mid = (l + r) / 2;
            // when middle num less than the right num, move right index to mid since min could be min but min cannot be anything higher than mid
            if (nums[mid] < nums[r]) r = mid;
            // when middle num greater than right num, move left index to mid + 1 since we don't need mid or anything b4 as they must not be min
            else if (nums[mid] > nums[r]) l = mid + 1;
            // nums[mid]=nums[r] can eliminate nums[r]
            else r--;
        }
        return nums[l];
    }
}