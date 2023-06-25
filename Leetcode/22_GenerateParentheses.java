class Solution {
    List<String> list;
    int n;
     public List<String> generateParenthesis(int n) {
        list = new ArrayList<String>();
        this.n = n;
        backtrack("", 0, 0);
        return list;
    }
    
    public void backtrack(String str, int open, int close){
        // if cur str has n * 2 bracket count then we are done
        if(str.length() == n*2){
            list.add(str);
            return;
        }
        // if we can afford to more left brackets (less than n), then add more
        if(open < n) backtrack(str+"(", open+1, close);
        // if we can afford to add more right brackets (less than left brackets), then add more
        if(close < open) backtrack(str+")", open, close+1);
    }

    // public List<String> generateParenthesis(int n) {
    //     List<String> result = new ArrayList<>();
    //     // base case
    //     if (n == 0) result.add("");
    //     // for every 'split' in a string of n paranthesis'
    //     for (int s = 0; s < n; s++){
    //         // for every combination of left, and right of the split
    //         for (String left: generateParenthesis(s)){
    //             for (String right: generateParenthesis(n-s-1)){
    //                 result.add("(" + left + ")" + right);
    //             }
    //         }
    //     }
    //     return result;
    // }
}