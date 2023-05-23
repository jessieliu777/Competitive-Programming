class Solution {
    public int findComplement(int num) {
        // Integer.highestOneBit gets the left most bit. if num = 5 = 101 then Integer.highestOneBit = 100 
        // Create a bit mask which has N bits of 1 from RIGHTMOST. In above example, the mask is 111. And we can use the decent Java built-in function Integer.highestOneBit to get the LEFTMOST bit of 1, left shift one, and then minus one: int mask = (Integer.highestOneBit(num) << 1) - 1;
        // This is a wonderful trick to create bit masks with N ones at RIGHTMOST
        // Then simply take the bits that are only in one and not the other => since mask is only 1's then these bits are the 0's in num
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }
}