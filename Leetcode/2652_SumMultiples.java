class Solution {
    private int cal(int n, int k) {
        // To get sum of all factors on k upto n, we can have this formula (sum of Arithmatic progression): k * (n/k) * (n/k + 1) / 2
// If you woder how we get above formula then check this out :
// k + 2k + 3k + 4k + ..... xk = k (1 + 2 + 3 + 4 ... x) = k( (x )( x + 1)/2 )
// where x is the largest value of (xk <= n) => (x <= n/k)
        return k *(n/k)*(n/k+1)/2;
    }

    public int sumOfMultiples(int n) {
    // To get the ans, we can sum :
    // sum all the factor of 3 + sum of all the factors of 5 + sum of all the factors of 7 - sum of all the factor of 3 * 5 - sum of all the factors of 5 * 7 - sum of all the factors of 3 * 7 + sum of all the factors of 3 * 5 * 7.
        return cal(n, 3) + cal(n, 5) + cal(n, 7) - cal(n, 3*5) - cal(n, 5*7) - cal(n, 3*7) + cal(n, 3*5*7);
    }
}