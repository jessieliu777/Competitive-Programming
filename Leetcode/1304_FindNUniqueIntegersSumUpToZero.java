class Solution {
    public int[] sumZero(int n) {
        // Naive idea
        // n = 1, [0]
        // n = 2, [-1, 1]

        // Now write more based on this
        // n = 3, [-2, 0, 2]
        // n = 4, [-3, -1, 1, 3]
        // n = 5, [-4, -2, 0, 2, 4]

        // It spreads like the wave.

        // Explanation
        // Find the rule
        // A[i] = i * 2 - n + 1

        // Math Observation
        // Actually, this rule could be derived from constructing an arithmetic sequence.
        // (Note that any arithmetic sequence must have unique values if the common delta is non-zero)
        // We need the sequence sum, so that
        // (a[0] + a[n-1]) * n / 2 = 0, which means a[0] + a[n-1] = 0.
        // Note that a[n-1] - a[0] = (n-1) * delta, which is -2 * a[0],
        // so we simply set delta = 2, a[0] = 1 - n

        // Note
        // It's not bad to sum up 1 + 2 + 3 + ... + (N - 1).
        // Personally I don't really like it much.
        // What is the possible problem of this approach?
        // It doesn't work if N goes up to 10^5

        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = i * 2 - n + 1;
        return A;
    }
}