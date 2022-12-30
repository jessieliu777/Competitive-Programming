class Solution {
    public int findClosestNumber(int[] nums) {
        int res = 100001;
        for(int i: nums)
            if(Math.abs(i) < Math.abs(res) || i == Math.abs(res))
                res = i;
        return res;
    }
}