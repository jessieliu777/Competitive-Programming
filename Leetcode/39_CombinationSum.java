class Solution {
    private void combSum(int i,List<List<Integer>>combinations,int candidates[],int target,List<Integer> combination) {
		if(i == candidates.length) {
            // if we've reached the target so that there's no leftovers
            if (target == 0){
                combinations.add(new ArrayList<>(combination));
            }
            return;
        }
		
		// try adding element if it's smaller than target
        if(candidates[i] <= target) {
            combination.add(candidates[i]);
            // get the combinations with current element
            combSum(i,combinations,candidates,target-candidates[i],combination); 
            // get the combinations with out current element
            combination.remove(combination.size()-1); 
        }
        combSum(i+1,combinations,candidates,target,combination);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        combSum(0,combinations,candidates,target,new ArrayList<>());
        return combinations;
    }
}