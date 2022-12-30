class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        // counts the number of times num is in nums. Since we are given 1 <= num <= 1000 we can set count to have len 1000. Since index start at 0 count[num-1] gives the count of num.
        int[] count  = new int[1000]; 
        for(int[] arr : nums) for(int num : arr) count[num-1]++;
        // only add the nums that appear in all arrays
        for(int i=0;i<count.length;i++) if(count[i]==nums.length) ans.add(i+1);
        return ans;
    }
}