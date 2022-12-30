class Solution {
    public int bitwiseComplement(int n) {
        // what is the relationship between input and output?
        // input + output = 111....11 in binary format

        // Let's find the first number x that x = 1111....1 > n

        // n + bitwiseComplement(N) = 11....11 = X
        // Then bitwiseComplement(N) = x - n

        int x = 1;
        while (n > x) x = x * 2 + 1;
        return x - n;
    }
}