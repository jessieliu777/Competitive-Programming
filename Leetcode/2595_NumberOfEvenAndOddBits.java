class Solution {
    public int[] evenOddBit(int n) {
        // given n <= 1000, there are 10 bits at most, so make each mask 10 bits
        return new int[] {Integer.bitCount(n & 0b0101010101), Integer.bitCount(n & 0b1010101010)};
    }
}