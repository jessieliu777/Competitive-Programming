class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = 0, xor2 = 0;
        for (int a1: arr1)
            xor1 ^= a1;
        for (int a2: arr2)
            xor2 ^= a2;
        return xor1 & xor2;
    }
}