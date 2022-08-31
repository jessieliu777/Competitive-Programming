class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        for (int i = 3; i <= n; i++){
            result[i] = result[i-3] + result[i-2] + result[i-1];
        }
        return (result[n]);
    }
}