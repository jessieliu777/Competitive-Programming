class Solution {
    public int longestOnes(int[] nums, int k) {
        // max number of consec 1s with at most k 0s <=> the longest subarr with at most k 0s
        int left = 0, right = 0;
        // use sliding window
        for (right= 0; right < nums.length; right++) {
            // if cur term is 0, flip it so now we have k-1 more 0s we can flip
            if (nums[right] == 0) k--;
            // if k goes negative, that means we flipped a 0 even tho we don't have enough flips, then we need to move the left pointer forward to make up for the extra length. If by moving forward we leave out a 0 then 'credit' the flip count since we should 'unflip' the ones that got out of the window. When this happens, the window len stays the same as the previous iteration as the above line increments right but this line increments left.
            if (k < 0 && nums[left++] == 0) k++;
        }
        // return the length of the window. At the end of the loop the window should be maximal
        return right-left;
    }
}