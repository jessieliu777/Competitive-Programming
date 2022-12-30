class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int)1e6;
        while (left < right) {
            int middle = (left + right) / 2, sum = 0;
            for (int num : nums) sum += (num + middle - 1) / middle; // (num + middle - 1) / middle = (num-1)/middle + 1 does the same as ceil(num/middle) 
            if (sum > threshold) left = middle + 1;
            else right = middle;
        }
        return left;
    }
}