class Solution {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int size = nums1.size(), sum1 = 0, sum2 = 0, dp[] = new int[size + 1];
        // If we do nothing, we will have sum2 * i + sum1 in total at i seconds.
        
        List<List<Integer>> nums2nums1 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int a = nums1.get(i), b = nums2.get(i);
            nums2nums1.add(Arrays.asList(b, a));
            sum1 += a;
            sum2 += b;
        }
        // sort by nums2. The sorted list [nums2[j],nums1[j]] is necessary, because for a given i seconds which we will use, we need to consider those smaller nums2[j]s first to help us construct correct dp, while those small nums2[j]s are not necessarily selected in deciding the final dp[i]
        Collections.sort(nums2nums1, (o1, o2) -> Integer.compare(o1.get(0), o2.get(0)));
        // for every column, it will be zeroed out (operation) for at most once(as we want to minimize the total time, there is no need to clean a column for more than once, the smart way is to combine multiple operations)

        // for every index
        for (int j = 0; j < size; ++j)
            // for every possible seconds = number of opertions (by 1, no need to zero out more then j+1 times)
            // i in traversed in reverse order to ensure the (nums2, nums1) pair won't be used for more than once for the potentional next iterations of this inner loop
            for (int i = j + 1; i > 0; --i)
                // dp[i] = the maximum value can be deducted in i seconds within j+1 operations
                // dp[i] = the dp[i] from previous iteration (i+1) or the maximum value deducted in i-1 seconds within j seconds + the value by deducting the jth element (= jth element at i seconds should have value = i seconds * nums2[j] + num1[i])
                dp[i] = Math.max(dp[i], dp[i - 1] + i * nums2nums1.get(j).get(0) + nums2nums1.get(j).get(1));
        
        // now go through every possible time starting from 0s, if by deducting the maximal value from total value = sum2*1+sum1 is at most x, then return this time
        for (int i = 0; i <= size; ++i) if (sum2 * i + sum1 - dp[i] <= x) return i;
        return -1;
    }
}