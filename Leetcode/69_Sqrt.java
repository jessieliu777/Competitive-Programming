class Solution {
    public int mySqrt(int x) {
        int i = 0;
        // 46340 is the floor of the square root of max int
        while (i*i <= x && i <= 46340){
            i++;
        }
        return i-1;
    }
}