class Solution {
    public void helper(List<Integer> subset, int index, int[] nums, List<List<Integer>> result){
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // add the subsets that contain number at index                 
        subset.add(nums[index]);
        helper(subset, index+1, nums, result);
        
        // add the subsets that doesn't contain number at index
        subset.remove(subset.size()-1);
        helper(subset, index+1, nums, result);               
        
        return;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(new ArrayList<>(), 0, nums, result);
        return result;
    }
}