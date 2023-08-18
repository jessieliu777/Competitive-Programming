class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int len = nums.length, indexOf1 = 0, indexOfN = 0;
        for (int k = 0; k < len; k++) {
            if (nums[k] == 1) indexOf1 = k;
            if (nums[k] == len) indexOfN = k;
        }
        // If index of 1 is i,
        // 1 needs i swaps to be the first.

        // If index of n is j,
        // n needs n - 1 - j swaps to be the last.

        // If i < j,
        // res is i + (n - 1 - j).

        // If i > j,
        // res is i + (n - 1 - j) - 1 (when i, j swaps, that is 1 swap instead of 2 since it moves each num closer to destination, so we save 1 swap at the intersection),
        // save one swap when swap 1 and n.
        return indexOf1 + (len - 1 - indexOfN) - (indexOf1 > indexOfN ? 1 : 0);
    }
}