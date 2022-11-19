class Solution {
    public int myAtoi(String s) {
        int i=0, sign=1, total=0, len = s.length();
        if(len==0)return 0;
        
        // skip white spaces, if the entire string is spaces then return 0
        while(i < len && s.charAt(i) == ' ') i++;
        if(len <= i) return 0;
        
        // if the leading char is a sign, get the sign
        if(s.charAt(i)=='+' || s.charAt(i)=='-')
        {
            sign= s.charAt(i)=='+' ? 1:-1;
            i++;
        }
        
        // for the chars after the potential leading spaces and potential sign
        while(i<len){
            // if it's not a digit then we are done
            int digit= s.charAt(i)-'0';
            if(digit<0 || digit >9) break;
            
            // if overflow then return the bounds
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            // add the digit
            total=10*total + digit;
            i++;
        }
        
        
        return total*sign;
    }
}