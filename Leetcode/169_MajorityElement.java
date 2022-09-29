class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.merge(num, 1, Integer::sum);
            if (map.get(num) > nums.length/2){
                return num;
            }
        }
        return -1;
    }
}