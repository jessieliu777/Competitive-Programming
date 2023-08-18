class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        // len[i]: the length of the Longest Increasing Subsequence which ends with nums[i].
        // cnt[i]: the number of the Longest Increasing Subsequence which ends with nums[i].
        int[] len =  new int[n], cnt = new int[n];
        // sliding window of nums[j:i]
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j < i; j++){
                // if cur subwindow is increasing (j, i)
                if(nums[i] > nums[j]){
                    // if the length of the LIS ends with nums[j] is the exactly one less as the length of the LIS ends with nums[i], then for all the LIS ending with nums[j], we can simply append them to nums[i] to get new len[j] number of LISs
                    if(len[i] == len[j] + 1) cnt[i] += cnt[j];
                    // but if the length of LIS ending at nums[i] isn't long enough to do the above, then we found a longer IS by ditching every LIS that ends in nums[i] and get new LIS by using LIS that ends in nums[j] and append nums[i]. Hence the length of these new LIS ending in nums[i] is len[j] + 1, and the number of these such LISs ending in i is the same as the nums of the LISs ended in j used.
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            // updated the largest LIS count
            if(max_len == len[i]) res += cnt[i];
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}