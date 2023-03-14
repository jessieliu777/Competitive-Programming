class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int earlestStartIndex = 0;
        int latestMinIndex = -1;
        int latestMaxIndex = -1;

        // for all possible subarrays that ends at i inclusive
        for (int i = 0; i < nums.length; i++) {
            // if i is ot between minK and maxK then it's invalid
            if  (nums[i] < minK || nums[i] > maxK) {
                latestMinIndex = -1;
                latestMaxIndex = -1;
                // the next subarray starts by skipping over the invalid element
                earlestStartIndex = i + 1;
            }
            if (nums[i] == minK) latestMinIndex = i;
            if (nums[i] == maxK) latestMaxIndex = i;
            // the subarr ends at i, but the start can be any from the starting index of the subarr denoted b earlestStartIndex, and the earliest index of the min bound or the max bound (the later one is guarenteed to be included since it's between the earlier one and i iclusive'). earliestStartIndex is guarenteed to be before the min/max indicies for a valid subarr since the valid case of i, only the min/max indices get updated.  The contrapositive is in the case earliestStartIndex isn't before the min/max indicies then it there must be no valid subarrs, which we want to add 0 as there are no new subarrs. 

            // if there exists some valid subarr that ends at i 
            // => add the count of all such subarrs to result
            // => add all the subarrs that ends in i to result 
            // => number of possible subarrs that ends in i = number of possible starting indices (the ones that don't include i should be counted in prev iterations) 
            // => starting index has to be between earliestStartIndex and the earliest one of min/max index inclusive to include both min and max 
            // => starting index has to be between earliestStartIndex and Math.min(latestMinIndex, latestMaxIndex) inclusive
            // => number of possible starting indicies = Math.min(latestMinIndex, latestMaxIndex) - earlestStartIndex + 1 (+1 since inclusive, for ex when start earliest min/max index = earliestStartIndex we count as 1 not earliest min/max index - earliestStartIndex = earliestStartIndex-earliestStartIndex = 0)

            // if DNE some valid subarr that ends at i
            // => add 0 since there are no new subarrs
            // remember how if earliestStartIndex isn't before the min/max indicies then there must be no valid subarrs
            // so if Math.min(latestMinIndex, latestMaxIndex) - earlestStartIndex + 1 < 0 then add 0

            // combine the above 2 cases together, we add Math.max(0L, Math.min(latestMinIndex, latestMaxIndex) - earlestStartIndex + 1)
            result += Math.max(0L, Math.min(latestMinIndex, latestMaxIndex) - earlestStartIndex + 1);
        }
        return result;
    }
}