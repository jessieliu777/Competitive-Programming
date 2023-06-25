class Solution {
    public int minFlips(int a, int b, int c) {
        // Step 1: a | b is what we have while c is what we want. An XOR operation finds all different bits, i.e. (a | b) ^ c sets the bits where flip(s) is needed. Then we count the set bits.
        // Step 2: There is only one case when two flips are needed: a bit is 0 in c but is 1 in both a and b. An AND operation finds all common 1 bits, i.e. a & b & ((a | b) ^ c) sets the common 1 bits in a, b and the must-flip bits found in Step 1. 
        // for ex a = b = 1, c = 0, both a b needs 1 flip each so 2 flips in total to reach c
        // step 1 counts 1 flip. step 2 checks if the bits that needs flips (result of (a | b) ^ c) is on) needs another flip, 1 & 1 & 1 is 1, so add another flip. total step 1 + step 2 = 1 + 1 + 1
        return Integer.bitCount(c ^= (a | b)) + Integer.bitCount(a & b & c);
    }
}