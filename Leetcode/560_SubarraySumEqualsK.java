class Solution {
    public int subarraySum(int[] nums, int k) {
        // Solution 1. Brute force. We just need two loops (i, j) and test if SUM[i, j] = k. Time complexity O(n^2), Space complexity O(1). I bet this solution will TLE.

        // Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>(); // preSum[i] = freq of sum i
        preSum.put(0, 1); // freq of 0 is init to be 1 since empty arr sums to 0
        
        for (int num : nums) {
            // add cur num to sum
            sum += num;
            // check if sum[0,,cur] - k exists, if so that means some sum [0,..,i-1] where i <= cur and that sum = cur sum - k. So we can take the difference arr sum[i,..,cur] and it must sum to k. the freq of sum [0,...,i-1] is the same as the freq of sum [0..,cur]-k, so need to add its freq to result count.  
            result += preSum.getOrDefault(sum - k, 0);
            // update freq of cur sum
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }   
        return result;
    }
}