class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        combination(new ArrayList<Integer>(), k, 1, n);
        return result;
    }

    private void combination(List<Integer> comb, int k,  int start, int n) {
        int curSize = comb.size();
        // if oversize then no solution
        if (curSize > k) return;
        // if we've fund k numbers that sum up to n (there are no more sum to go => n = 0)
        else if (curSize == k && n == 0) {
            // then add cur comb to result
            List<Integer> li = new ArrayList<Integer>(comb);
            result.add(li);
            return;
        }
        // for every number from 1 thru 9 (given bound in question)
        for (int i = start; i <= n && i<=9; i++) { 
            // get all the combinations with this number
            comb.add(i);
            // since we've added i, there is n-i sum to go
            combination(comb, k, i+1, n-i);
            // remove this number so the future iterations will get all the combinations without this number
            comb.remove(comb.size() - 1);
            
        }
    }
}