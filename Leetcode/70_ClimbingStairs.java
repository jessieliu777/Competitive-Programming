class Solution {
    public int climbStairs(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            if (i == 0) {
                result.add(1);
            } else if (i == 1) {
                result.add(2);
            } else {
                result.add(result.get(i-2) + result.get(i-1));
            }
        }
        return result.get(n-1);
    }
}