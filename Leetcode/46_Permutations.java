class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, nums, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, int[] nums, int start){
        // if we went through all the nums, add to result
        if (start == nums.length){
            List<Integer> permutation = new ArrayList<>();
            for (int num: nums){
                permutation.add(num);
            }
            result.add(permutation);
        } else {
            for (int i = start; i < nums.length; i++){
                 // repeat the same process with different start number
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                helper(result, nums, start+1);
                // swap back
                nums[i] = nums[start];
                nums[start] = temp;
            }
        }
    }
}