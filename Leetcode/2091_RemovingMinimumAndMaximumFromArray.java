class Solution {
    public int minimumDeletions(int[] nums) {
        int i = 0, j = 0, n = nums.length; // i = index of max, j = index of min
        for (int k = 0; k < n; k++) {
            if (nums[i] < nums[k]) i = k;
            if (nums[j] > nums[k]) j = k;
        }
        // min(doing all dels from one side, del each num from each side)
        return Math.min(
            // min(the dels from the front til we del'd both i j, the dels from the back til we del'd both i j)
            Math.min(
                Math.max(i + 1, j + 1), Math.max(n - i, n - j)), 
            // min(dels from front til the i + dels from back to j, dels from front til j + dels from back til i )
            Math.min(i + 1 + n - j, j + 1 + n - i));
    }
}