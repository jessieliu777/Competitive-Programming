class Solution {
    public int concatenatedBinary(int n) {
        final long modulo = (long) (1e9 + 7);
        long result = 0;
        int leftShift = 0;
        for (int i = 1; i <= n; i++) {
            // if power of 2, do an additional left shift
            if ((i & (i - 1)) == 0) leftShift++;
            //left shifted result = result * 10^leftshiftedbits
            result = ((result << leftShift) + i) % modulo;
        }
        return (int) result;
    }
}