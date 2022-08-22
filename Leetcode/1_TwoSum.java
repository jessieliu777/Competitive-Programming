class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for every number, add target-number to hashset
        // if there's any number that's in the hashset, it's the answer
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target-nums[i])){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
            }
            map.put(nums[i], i);
        }
        return result;
    }
}