class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        if (x % 10 == 0) return false;
        // get the last digit using mod
        // the second last using /
        int reversed = 0;
        while (x > reversed){
            // get the last digit
            int last = x % 10;
            reversed = reversed*10 + last;
            x /= 10;
        }
        return x == reversed || x == reversed/10;
    }
}