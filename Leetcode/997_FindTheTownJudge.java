class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        int[] trusted = new int[n]; // trusted[i] = number of people that trusts i-1
        for (int[] t: trust){
            trusted[t[0]-1]--;
            trusted[t[1]-1]++;
        }
        int judgeCount = 0;
        int judge = -1;
        for (int i = 1; i <= n; i++){
            if (trusted[i-1] == n-1){
                judgeCount++;
                judge = i;
            }
        }
        return judgeCount == 1 ? judge : -1;
    }
}