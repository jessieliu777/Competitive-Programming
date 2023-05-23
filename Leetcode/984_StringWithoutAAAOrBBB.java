class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder res = new StringBuilder(a + b);
        // assume a >= b
        char longChar = 'a', shortChar = 'b';
        int longLen = a, shortLen = b;
        // if a < b then swap
        if (shortLen > longLen) { 
            longChar = 'b'; 
            shortChar = 'a'; 
            longLen = b; 
            shortLen = a; 
        }
        // for each iteration, deduct longLen and shortLen. For each deduction, add the respective char. Now since longLen have extra chars to add, deduct longLen again so that each iteration deducts longLen twice until longLen 'catches' up to shortLen there's no longer need to deduct twice so after that deduct once just like shortLen. Given it's always possible result exists, there is no longLen such that longLen > 2*shortLen so worse case longLen = 2*shortLen this method still works. 
        while (longLen-- > 0) {
            res.append(longChar);
            if (longLen > shortLen) { 
                res.append(longChar); 
                longLen--; 
            }
            if (shortLen-- > 0) res.append(shortChar);
        }
        return res.toString();
    }
}