class Solution {
    public int arrayNesting(int[] nums) {
        int maxsize = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int k = i; nums[k] >= 0; size++) {
                int cur = nums[k];
                nums[k] = -1; // mark a[k] as visited;
                k = cur; // next index is cur element
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }
}