class Solution {
    public int[] plusOne(int[] digits) {
        // go through every digit starting from right
        for(int i=digits.length-1; i>=0; i--){
            // if it's less than 9, then just increment this digit and return 
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            // otherwise set to 0, we still need to check the next left digit
            digits[i]=0;
        }
        // if we got here then all the digits are 9, so we need a new digit 1 at the leftest, and all other digits are 0
        int[] newArr=new int[digits.length+1];
        newArr[0]=1;
        return newArr;
    }
}