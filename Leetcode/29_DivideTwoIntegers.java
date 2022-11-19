class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
//         1. Exponensly increase the divisor until before it surpass the dividend then substract with it.
// 2. Add up the divisor and find the remainder.
// 3. Repeat the same until it brings to 0
        int sign = Integer.signum(dividend) * Integer.signum(divisor);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0, subQuot = 0;
        
        while (dividend - divisor >= 0) {
            // Left Shift (<<) shall be considered as multiplication by 2^N
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot; //Add to the quotient
            dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
        }
        return quotient * sign;
    }
}