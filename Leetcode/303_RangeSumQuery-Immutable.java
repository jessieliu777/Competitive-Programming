class NumArray {
    int[] preSum;
    public NumArray(int[] nums) {
        preSum = nums; // pass by pointer!
        // preSum[i] = sum of all elements from preSum[0] to preSum[i]
        for (int i = 1; i < preSum.length; i++) preSum[i] += preSum[i-1]; 
    }
    
    public int sumRange(int left, int right) {
        return left == 0 ? preSum[right]: preSum[right] - preSum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */