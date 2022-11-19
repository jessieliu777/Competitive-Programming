class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> v = new ArrayList<Integer>();
        // total num of bits = 2^n = 1<<n
        for(int i=0; i<1<<n; i++) {
            // i-bit gray code can be found as i^(i/2)
            // padd 0 in front of every element of i-1's gray code and then padd 1 before every element in reverse order 
            // for n = 3
            // i=0, j=i>>1 = 0 i ^ j=0  = [0+00]
            // i=1, j=i>>1 = 0 i ^ j=1 = [0+01]
            // i=2 j=i>>1 = 1 i ^ j=3 = [0+11]
            // i=3 j=i>>1 = 1 i ^ j=2 = [0+10]
            // i=4 j=i>>1 = 2 i ^ j=6 = [1+10]
            // i=5 j=i>>1 = 2 i ^ j=7 = [1+11] 
            // i=6 j=i>>1 = 3 i ^ j=5 = [1+01]
            // i=7 j=i>>1 = 3 i ^ j = 4 = [1+00]
            // we don't need to pad 0 as the binary representation already consists of 0, for padding 1 we use bitmask ie 1<<(n-1) as for n = 2 we need to add 1 to 2nd place ie shift 1 by 1 place
            v.add(i^(i>>1));
        }
        return v;
    }
}