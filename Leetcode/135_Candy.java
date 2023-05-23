class Solution {

    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
            int ret = 1;
            // up = number of continuous strictly increasing ratings (excluding first kid)
            // down = number of continuous strictly decreasing ratings (excluding first kid and peak kid)
            // peak = highest point in the cur consecutive increasing ratings. (If cur rating is decreasing, store the last peak of strictly increasing subset. If cur rate is same as before, reset)
            int up = 0, down = 0, peak = 0; 
            for (int i = 1; i < ratings.length; i++) {
                // if cur slope is / then update peak to be one higher, reset down
                if (ratings[i - 1] < ratings[i]) {
                    peak = ++up;
                    down = 0;
                    // cur kid needs to get more candies than the others in this continuous subset of increasing ratings, which the length of that is up + 1 including cur kid. assuming minalist, for all i from 1 to up, the ith kid receive i candies. This kid is the up+1st in the continuous subset so they receive up + 1
                    ret += up + 1;
                } 
                // slope stays flat => cur kid gets same as prev, but we don't need to give them that much as it's not asked in the question. So giving cur kid 1 is enough. Reset peak, up, down as we've reached a flat slope.
                else if (ratings[i - 1] == ratings[i])  {
                    peak = up = down = 0;
                    ret += 1;
                } 
                // if slope is \, reset up. Note we leave peak to store the last peak of the last strictly increasing ratings subarr
                else {
                    up = 0;
                    down++;
                    // when peak >= down, the candy for the peak still don't need to change. Cur kid gets 1, but the kid before needs to ge 1 more, and so on for all kids in the continuous strictly decreasing subarr => there are down amount of kids so total is +down amount of candies. 
                    // But if peak < down then after all the kids in the decreasing subarr gets an extra candy, like above, they would reach the kid at the peak (since by minimalist the kid at peak should be getting peak amount of candies, while the highest rating kid in the decreasing consec array should be getting down candies), so give the kid at the peak an extra candy. 

                    // For example, [0, 1, 20, 9, 8, 7], for the first 5 number, we need to assign [1,2,3,2,1] candies. peak = 2, down = 2
                    // But when 7 comes up, we need to raise the value of the peak, which is 3 above, it need to be 4, [1,2,4,3,2,1] peak = 2, down = 3
                    ret += 1 + down + (peak >= down ? -1 : 0);
                }
            }
            return ret;
    }
}