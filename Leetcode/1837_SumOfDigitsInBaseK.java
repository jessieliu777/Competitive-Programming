class Solution {
    public int sumBase(int n, int k) {
        int reults = 0;
        for (; n > 0; n /= k)
            reults += n % k;
        return reults;
    }
}