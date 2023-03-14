class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        // if there's one num then it's the peak
        if (len == 1) return 0;
        // do binary search
        int left = 0, right = len - 1;
        // while there are at least 2 nums in nums[left:right] 
        while (right > left + 1) {
            // take the middle from this window
            int mid = left + (right - left) / 2;
            // if the middle number is smaller than the righter element then move the left pointer to the right of mid -> now we just need the next left to be greater than its righter element
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            // if the middle number is at least the righter element then move the right pointer to mid
            else right = mid;
        }
        // if left is higher: either it's at the edge of the RHS (even all edge nums r higher than the potential num outside of array) or it s higher than the righter num then return left. Otherwise return right
        return (left == len - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
}