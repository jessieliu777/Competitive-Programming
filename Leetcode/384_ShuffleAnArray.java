class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        if (nums == null) return null;
        int[] copy = nums.clone();
        for(int j = 1; j < copy.length; j++) {
            // nextInt(j + 1) returns a random num between [0, j]. By nextInt(j), you never get a chance to return the original order array hence nextInt(j+1)
            int i = random.nextInt(j + 1);
            swap(copy, i, j);
        }
        return copy;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */