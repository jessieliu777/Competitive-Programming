class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        //traverse each digit of n, for ex if n=3401512
        //for ex: placeValue=100 (hundreds digit) split n into quotient=34015 and remainder=12
        
        //case 1: quotient%10==1 
        // #1=quotient/10*placeValue+(remainder+1) 
        // if quotient ends in a 1 (if quotient[-1] == 1), then quotient has quotient[:len-1] = quotient/10 1's:
        // if placeValue = 1000, then quotient = 3401, remainder = 512 
        // quotient[-1] = 3401[-1] = 1, so there are 341 different numbers from 0 to 340 that we can replace quotient[:len-1] (11, 21,...,101, 111, ...3391, 3401) => add quotient/10+1 more ways
        // [quotient[-1], *remainder] has remainder different numbers from 1 to remainder. since remainder is on RHS, it can also be replaced with 0 (10,11,12,...,111,112) => add remainder + 1 ways
        // Note the number itself will be repeated as we included the split digit from RHS and LHS so -1
        // in total = quotient/10 * placeValue + 1 + remainder + 1 - 1 
        // = quotient/10 * placeValue + remainder + 1 
        // = (quotient+8)/10 * placeValue + reminder + 1 ways (since quotient last digit is 1, then quotient +8 ends in 9 so the result of /10 is still the same)

        // case 2: When thousand's-digit equals 0: let's say quotient=3140 and remainder=592.
        // (2.1) For left part, XXX0592, if XXX is from 0 to 313, the resultant number can always contain 1 at the thousand-digit as XXX1592; if XXX is 314, the thousand's-digit can not be 1 otherwise the resultant number will be greater than n => 313 one's = (quotient/10)-1
        // (2.2) For right part, 3140XXX, any XXX will not contribute ones on the thousand's-digit position.
        // (since we traverse from RHS, that is placealue = 1, then any of the righter ones contribution should be already counted in prev iterations)
        // (2.3) So the total ones = 314 000 = quotient/10 * placeValue = (quotient+8)/10 (since quotient ends in 0, /10 is still the same as quotient+8 ends in 8)

        // case 3: quotient ends in a digit > 1
        // same as case digit = 0, but this time we can include quotient[:len-1] as it won't exceed n
        // for ex quotient = 3142, remainder = 592
        // LHS can be 0,..., 314 since if split digit is a 1 then 3141XXX is still less than n=3142592
        // so total = ((quotient/10) + 1) * placeValue
        // = (quotient+8)/10 * placeValue, since digit >=2 then in all cases +8 will make the result of /10 1 larger than b4

        // in all 3 cases the result is (quotient+8)/10 * placeValue + (quotient % 10 == 1 ? remainder + 1 : 0)

        for (long placeValue = 1; placeValue <= n; placeValue *= 10) {
            long quotient = n/placeValue;
            long remainder = n%placeValue;
            // ones += all the numbers leq n where the placeValue digit is a 1
            ones += (quotient + 8) / 10 * placeValue + (quotient % 10 == 1 ? remainder + 1 : 0);
        }
        return ones;
    }
}