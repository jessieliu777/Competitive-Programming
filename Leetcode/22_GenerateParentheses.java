class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // base case
        if (n == 0) result.add("");
        // for every 'split' in a string of n paranthesis'
        for (int s = 0; s < n; s++){
            // for every combination of left, and right of the split
            for (String left: generateParenthesis(s)){
                for (String right: generateParenthesis(n-s-1)){
                    result.add("(" + left + ")" + right);
                }
            }
        }
        return result;
    }
}