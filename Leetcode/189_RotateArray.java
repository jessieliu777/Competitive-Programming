class Solution {
    public void rotate(int[] nums, int k) {
        // if k is greater than the nums length, then it will go a 'full circle'
        k = k % nums.length;
        // split the array into 2 at k
        int[] left = Arrays.copyOfRange(nums, 0, nums.length - k);
        int[] right = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        
        System.arraycopy(right, 0, nums, 0, right.length);
        System.arraycopy(left, 0, nums, right.length, left.length);
    }
}