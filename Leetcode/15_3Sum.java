class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array so we can skip duplicates
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // for every i
        for (int i = 0; i < nums.length-2; i++){
            // skip duplicates
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // use 2 pointers, from i+1th element to last
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                // if too small, move left
                if (sum < 0){
                    left++;
                } 
                // f too large, move right
                else if (sum > 0){
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    // skip duplicates
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                }
            }
        }
        return result;
    }
}