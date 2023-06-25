class Solution {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        int windowSize = 2 * k + 1;
        
        long windowSum = 0;
        int[] result = new int[len];
        Arrays.fill(result,-1);

        if (len < windowSize) return result;
        
        for (int i = 0; i < len; ++i) {
            // add cur num to window
            windowSum += nums[i];
            // remove the num that got chopped from sliding window
            if (i - windowSize >= 0) windowSum -= nums[i - windowSize]; 
            
            // if we reached the end of window, Calculate and store the average in the result
            if (i >= windowSize - 1) result[i - k] = (int) (windowSum / windowSize);
        }

        return result;
    }
}