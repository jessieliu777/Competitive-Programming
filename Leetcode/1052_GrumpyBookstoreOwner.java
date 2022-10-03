class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0, max = 0;

        for(int i = 0, extra = 0; i < grumpy.length; i++){
            if(grumpy[i] == 0)
                res += customers[i];//take sum when owner isn't grumpy cause this is what greedy looks like
            else
                extra += customers[i];//include in window 

            if(i >= minutes && grumpy[i - minutes] == 1)//when we have reached our window limit(x), it's time to slide it
                extra -= customers[i - minutes];//exclude (i - x)th index value from window

            max = Math.max(max, extra);//store the maximum extra we can get using super powers
        }
        return res + max;
    }
}