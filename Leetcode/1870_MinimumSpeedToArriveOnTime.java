class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        // given min ans is 1, max is 10^7
        int min = 1, max = 10000000;
        int ans = -1;
        // do binary search
        while(min <= max){
            // get the median of possible answers
            int mid = (max + min)/2;
            // try to calculate total time taken using mid
            double tripTime = 0;
            for(int i = 0; i<n-1; ++i) tripTime += Math.ceil( ( (double) dist[i]) /mid);
            // no need for math.ceil since time taken by last train doesn't need to be converted into int since no need to 'wait'
            tripTime = tripTime + ( ( (double) dist[n-1]) /mid);
            // if trip time is too long then move left bound of window past cur mid
            if (tripTime > hour) min = mid+1;
            // otherwise save the cur mid as answer, move the right bound window past cur mid
            // since we reduced the window size new potential answers are strictly less than mid so update only happens when we find a smaller ans as wanted, and eventually will find the smallest ans as wanted
            else {
                ans = mid;
                max = mid-1;
            }
        }
        return ans;
    }
}