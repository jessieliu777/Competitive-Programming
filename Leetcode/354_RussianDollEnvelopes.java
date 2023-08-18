class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 1. Sort the array. Ascend on width and descend on height if width are same.
        // 2. Find the longest increasing subsequence based on height (Since the width is increasing, we only need to consider height)
        // [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
        Arrays.sort(envelopes, (a,b) -> (a[0]==b[0]) ? b[1]-a[1] : a[0]-b[0]);
        int dp[] = new int[envelopes.length]; // dp[i] = height of ith envelope in LIS
        int russianDolls = 0;
        for (int[] envelope : envelopes){
            // find the index or potential index of this envelope in LIS. since binarySearch last element is exclusive, calls binarySearch when init russianDolls = 0 will return index 0 regardless of envelope height
            int index = Arrays.binarySearch(dp, 0, russianDolls, envelope[1]);
            if(index < 0) index = -(index + 1);
            // update the index or potential index to be the height oft his envelope
            dp[index] = envelope[1];
            // if the updated index results in surpassing the amount of russianDolls so far, increment russianDolls. (Note if the index is one of them in russian dolls, the len of LIS doesn't change so no need do update)
            if(index == russianDolls) russianDolls++;
        }
        return russianDolls;
    }
}