class Solution {
    public int longestSubarray(int[] nums) {
        // sliding window with at most one 0 inside
        // we may change up to changes (in this case changes = 1 given in question) values from 0 to 1.
        // Return the length - 1 of the longest (contiguous) subarray that contains only 1s.
        int start = 0, changes = 1, res = 0;
        for (int end = 0; end < nums.length; end++) {
            // if we encounter a 0 then make the 'change'
            if (nums[end] == 0) changes--;
            // if there aren't enough changes (happens when we encountered the second 0) then we are done with this subarr, so move the starting window
            // move the starting window to the next 0 in the subarr
            while (changes < 0) {
                // if the first element is 0, then since we moved the window it no longer needed the change, so credit the change bk
                if (nums[start] == 0) changes++;
                start++;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}