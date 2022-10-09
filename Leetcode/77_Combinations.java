class Solution {
    private List<List<Integer>> combinations;
    public void helper(int n, int k, List<Integer> combination, int start){
        if (k==0) {
			combinations.add(new ArrayList(combination));
			return;
		}
		for (int i = start; i <= n - k + 1; i++) {
			combination.add(i);
			helper(n, k-1, combination, i + 1);
			combination.remove(combination.size() - 1);
		}
    }
    
    public List<List<Integer>> combine(int n, int k) {
        combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        helper(n, k, combination, 1);
        return combinations;
    }
}