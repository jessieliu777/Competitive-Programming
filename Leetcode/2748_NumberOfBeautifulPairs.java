class Solution {
    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    public int countBeautifulPairs(int[] nums) {
        int pairs = 0;
        for (int i = 0; i < nums.length; ++i) {
            // get last digit of nums[i]
            int d = nums[i] % 10;
            for (int j = 0; j < i; ++j) {
                int n = nums[j];
                // get first digit of nums[j]
                while (n >= 10) n /= 10;
                pairs += gcd(n, d) == 1 ? 1 : 0;
            }
        }
        return pairs;
    }
}