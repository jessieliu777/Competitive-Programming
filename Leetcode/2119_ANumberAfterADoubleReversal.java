class Solution {
    public boolean isSameAfterReversals(int num) {
        // if the first digit is not zero then there's no leading 0s so it has to be true. The only exception is if num is 0 then it's true. Otherwise false
        return num==0 || num%10!=0;
    }
}