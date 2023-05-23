class Solution {
    public long zeroFilledSubarray(int[] nums) {
        // compute the # of 0 filled subarrays for each continuous 0s and add them up
        // Whenever encounter a 0, use a variable zeroSubarraysEndingAtCurrentIndex to count the subarrays of only 0s: e.g., 0,0,0,0
        // the # of subarrays ending at 1st 0 is 1: 0,x,x,x
        // the # of subarrays ending at 2nd 0 is 2: x,0,x,x, 0,0,x,x
        // the # of subarrays ending at 3rd 0 is 3: x,x,0,x, x,0,0,x, 0,0,0,x
        // the # of subarrays ending at 4th 0 is 4: x,x,x,0, x,x,0,0, x,0,0,0, 0,0,0,0

        // There are 1 + 2 + 3 + 4 = 10 subarrays for 0,0,0,0.
        long cnt = 0, zeroSubarraysEndingAtCurrentIndex = 0;
        for (int n : nums) {
            if (n == 0) cnt += ++zeroSubarraysEndingAtCurrentIndex;
            else zeroSubarraysEndingAtCurrentIndex = 0;
        }
        return cnt;
    }
}