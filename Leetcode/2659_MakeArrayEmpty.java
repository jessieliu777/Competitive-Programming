class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        Map<Integer, Integer> pos = new HashMap<>(); // map[i] = index of i in nums
        // best case if nums is already sorted, takes one op to remove each num, hence initialize res to be nums length
        long n = nums.length, res = n;
        for (int i = 0; i < n; i++) pos.put(nums[i], i);
        Arrays.sort(nums);
        // When we find an item which index is smaller than the previous, it indicates we have iterated through the entire array and must repeat the previous step again. However this time the lenght of the array is no longer same since some of the items got removed.
        // The new lenght of the array will be n - number of removed items, thus n - i
        // for ex [3, 1, 4]
        // op 1: [1, 4, 3]
        // op 2: [4, 3]
        // op 3: [3, 4]
        // op 4: [4]
        // op 5: []
        // sorted arr is [1, 3, 4]
        // the orig index of 1 > 3, so when 3 gets removed 1 must been removed before + 3 must have been rotated
        // after 1 got remomved, 3's position must not be at the front since it got rotated b4 1 got removed
        // by the time 3 got removed, 3 must somehow got rotated to the front again.
        // so in total 3 made a full rotation out of the remaining numbers. since 1 got removed before, there are 2 numbers left out of the orig 3 in total, so 3 must be rotated 2 times. 
        // basically in every iteration result += the number of ops to get ith smallest number removed if the orig pos of ith smallest is greater than i-1st smallest
        for (int i = 1; i < n; i++) if (pos.get(nums[i]) < pos.get(nums[i - 1])) res += n - i;
        return res;
    }
}