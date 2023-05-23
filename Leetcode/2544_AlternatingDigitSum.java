class Solution {
    public int alternateDigitSum(int n) {
        // odd digits => ends with + sign => +, -, + ..., + => ends with - sign * -1 = ( -, +, - ..., -) * -1
        // even digits => ends with - sign => +, -, +, ..., - 
        // so either way we can start with the leftest digit using -, then alternte til we reach the rightest digit which also uses -. If number of digits is odd simply multiply result by -1 (Note if it''s even the sign turns to 1 the last iteration so * 1 changes nothing)
        int res = 0, sign = 1;
        while(n > 0){
            sign *= -1;
            res += n%10 * sign;
            n/=10;
        }
        return res*sign;
    }
}