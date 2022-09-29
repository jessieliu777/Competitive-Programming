class Solution {
    public int integerBreak(int n) {
        if(n == 2 | n == 3) return n - 1;
        // use as many 3's as possible
        double result = -1;
        int threes = n/3;
        if(n % 3 == 0) {
            result = Math.pow(3, threes);
        } else if(n % 3 == 1) {
            result = Math.pow(3, threes-1) * 4;
        } else {
            result = Math.pow(3, threes) * 2;
        }
        return (int) result;
    }
}