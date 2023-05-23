class Solution {
    public int arrangeCoins(int n) {
        // staircases are going to be 1 + 2 + 3 + 4 ..... + m-1 + m = (m* (m + 1))/2
        // you have to match m * (m+1) // 2 to highest possible m value such that the expression is less than n
        // sqrt(n) on a 32 bit integer is log(sqrt(INT_MAX)) which is 15

        // For simplicity, lets consider ours is 4 instead of 15 and n value is 47

        // so we have to find a 4 bit integer x such that (x * (x+1))/2 is less than 47. lets keep adding bits to position from msb to see how much far we can go

        // lets start,
        // adding at 4th pos : 1000 (8) : 8 * 9 / 2 = 36 < 47 : add bit to 4th position
        // adding at 3rd pos : 1100 (12) : 12 * 13 / 2 = 78 > 47 : dont add bit to 3rd position (remains 1000)
        // adding at 2nd pos : 1010 (10) : 10 * 11/ 2 = 55 > 47 : dont add bit to 2th position(remains 1000)
        // adding at 1st pos : 1001 (9) : 9 * 10 / 2 : 45 < 47 : add bit to 1st pos (ans = 1001)

        // final ans = 9
        int mask = 1 << 15;
        long result = 0;

        while (mask > 0) {
            // temp = num with the mask bit on
            long temp = result | mask;
            long coinsFilled = temp * (temp + 1) / 2;
            if (coinsFilled == n) return (int) temp;
            else if (coinsFilled < n) result = temp;
            // check for the next bit
            mask >>= 1;
        }

        return (int) result;
    }
}