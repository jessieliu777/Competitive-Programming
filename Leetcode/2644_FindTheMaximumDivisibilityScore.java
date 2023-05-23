class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int max = 0, res = divisors[0];
        for(int i=0; i<divisors.length; i++){
            int cnt = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[j] % divisors[i] == 0) cnt++;
            }
            if(cnt > max){
                max = cnt;
                res = divisors[i];
            } else if (cnt == max) res = Math.min(divisors[i], res);
        }
        return res;
    }
}