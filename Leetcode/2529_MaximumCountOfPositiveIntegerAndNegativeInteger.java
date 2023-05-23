class Solution {
    public int maximumCount(int[] nums) {
        int maxPos = 0;
        int maxNeg = 0;
        for (int num: nums){
            if (num > 0) maxPos++;
            else if (num < 0) maxNeg++;
        }
        return Math.max(maxPos, maxNeg);
    }
}