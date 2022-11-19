class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean[] visited = new boolean[10001];
        int duplicate = 0, sum = 0, n = nums.length;
        for (int num: nums) {
            if (visited[num]) {
                duplicate = num;
            }
            visited[num] = true;
            sum += num;
        }
        // expected sum of 1 to n + duplicate
        int expectedSum =  (n * (n+1)) / 2 + duplicate;
        return new int[] {duplicate, expectedSum - sum};
    }
}