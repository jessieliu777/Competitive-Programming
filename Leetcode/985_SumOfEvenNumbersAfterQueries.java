class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        // calculate initial even sum
        int sum = 0;
        for (int num: nums){
            if (num % 2 == 0) sum += num;
        }
        // for each query, calculate even sum
        for (int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            // if it used to be even, remove
            if (nums[query[1]] % 2 == 0){
                sum -= nums[query[1]];
            }
            nums[query[1]] += query[0];
            // if the new value is even
            if (nums[query[1]] % 2 == 0){
                sum += nums[query[1]];
            }
            result[i] = sum;
        }
        return result;
    }
}