class Solution {
    private void helper(int start,List<List<Integer>>combinations,int candidates[],int target,List<Integer> combination) {
		if(target < 0) return; /** no solution */
        else if(target == 0){
            combinations.add(new ArrayList<>(combination));
            return;
        } 
		// try adding element if it's smaller than target
        for (int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue; /** skip duplicates */
            combination.add(candidates[i]);
            helper(i+1, combinations, candidates, target - candidates[i], combination);
            combination.remove(combination.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,combinations,candidates,target,new ArrayList<>());
        return combinations;
    }
}