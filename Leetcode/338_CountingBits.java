class Solution {
    public int[] countBits(int n) {
        int[] f = new int[n + 1];
        // we have to count 1's in binary representation of i, therefore % 2
        for (int i=1; i<=n; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}