class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> result = new ArrayList<>();
        for (int i : nums) result.add((double) i);
        return dfs(result);
    }

    private boolean dfs(List<Double> result) {
        if (result.size() == 1) {
            // if the result is 24
            if (Math.abs(result.get(0)- 24.0) < 0.001) return true;
            else return false;
        }
        
        // pick 2 cards
        for(int i = 0; i < result.size(); i++) {
            for(int j = i + 1; j < result.size(); j++) {
                // for every possible result
                for (double c : compute(result.get(i), result.get(j))) {
                    List<Double> nextRound = new ArrayList<>();
                    // add it to the next round
                    nextRound.add(c);
                    // now add the remaining cards that aren't the 2 cards we picked
                    for(int k = 0; k < result.size(); k++) {
                        if(k == j || k == i) continue;
                        nextRound.add(result.get(k));
                    }
                    if(dfs(nextRound)) return true;
                }
            }
        }
        return false;

    }
    // compute next possible result
    private List<Double> compute(double a, double b) {
        List<Double> result = Arrays.asList(a+b, a-b, b-a, a*b, a/b, b/a);
        return result;
    }
}