class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cnt = 0; 
        int sum = 0;
		int t = k * threshold; // min sum for such subarray
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];  // accumulative sum adding head
            if (i < k - 1) continue;  // wait until we have k numbers in the subarray
            // if we have exactly k numbers, then just check the sum
            // but if we have more than k, then take one out because we can only have k
            else if (i > k - 1) sum -= arr[i - k];  // accumulative sum substract tail
            if (sum >= t) cnt++;  // found one
        }
        return cnt;
    }
}