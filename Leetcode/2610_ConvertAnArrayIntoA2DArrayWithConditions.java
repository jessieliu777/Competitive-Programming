class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        // given num[i] <= nums.length, we can use an array of size nums.length to map num to count
        int len = nums.length, count[] = new int[len + 1];
        for (int num : nums) {
            // if matrix has less rows than the current count of num (which should be pre incremented size cur num is num), then we need a new row for the extra count
            if (res.size() < ++count[num]) res.add(new ArrayList<>());
            // add cur num to the latest row (the repeated nums should already be added in all previous rows, and given each row can only contain one copy of num at most)
            res.get(count[num]-1).add(num);
        }
        return res;
    }
}