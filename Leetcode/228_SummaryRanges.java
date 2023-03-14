class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){
            int start=nums[i];
            // skip consec ones
            while(i+1<nums.length && nums[i]+1==nums[i+1]) i++;           
            if(start!=nums[i]) result.add(start+"->"+nums[i]);
            else result.add(Integer.toString(start));
        }
        return result;
    }
}