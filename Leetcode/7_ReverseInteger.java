class Solution {
    public int reverse(int x) {
        // repeatedly remove the last digit and put it at the front
        // get the last digit using x % 10
        int result = 0;
        while (x != 0){
            int lastDigit = x % 10;
            x /= 10; // remove last digit
            // if appending the digit to result would cause overflow
            if (result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && lastDigit > 7) return 0;
            if (result < Integer.MIN_VALUE/10 || result == Integer.MAX_VALUE/10 && lastDigit < -8) return 0;
            result = result * 10 + lastDigit;
        }
        return result;
    }
}