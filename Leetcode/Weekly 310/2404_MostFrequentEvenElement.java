class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 0){
                map.merge(nums[i], 1, Integer::sum);
            }
        }
        int freq = 0;
        int value = -1;
        for (Integer key : map.keySet()){
            if (map.get(key) > freq){
                freq = map.get(key);
                value = key;
            } else if (map.get(key) == freq){
                if (value == -1 || key < value){
                    freq = map.get(key);
                    value = key;
                }
            }
        }
        return value;
    }
}