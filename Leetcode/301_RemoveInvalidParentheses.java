class Solution {
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        remove(s, 0, 0, new char[]{'(', ')'});
        return result;
    }
    //     Key Points:

    // Generate unique answer once and only once, do not rely on Set.
    // Do not need preprocess.
    // Runtime 3 ms.
    // Explanation:
    // We all know how to check a string of parentheses is valid using a stack. Or even simpler use a counter.
    // The counter will increase when it is ‘(‘ and decrease when it is ‘)’. Whenever the counter is negative, we have more ‘)’ than ‘(‘ in the prefix.

    // To make the prefix valid, we need to remove a ‘)’. The problem is: which one? The answer is any one in the prefix. However, if we remove any one, we will generate duplicate results, for example: s = ()), we can remove s[1] or s[2] but the result is the same (). Thus, we restrict ourself to remove the first ) in a series of concecutive )s.

    // After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string. However, we need to keep another information: the last removal position. If we do not have this position, we will generate duplicate by removing two ‘)’ in two steps only with a different order.
    // For this, we keep tracking the last removal position and only remove ‘)’ after that.

    // Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘?
    // The answer is: do the same from right to left.
    // However a cleverer idea is: reverse the string and reuse the code!

    // 1. last_i and last_ j
    // back to the naïve core content of this algo, its essential advantage is at process redundant ")" from left to right, process redundant "(" from right to left, I think everyone understand this. Then let's focus on 2 contiguous recursions. Let's take '())())' as an example:
    // first recursion, last_ j = 1, the string is ())()), after deleting it the string is ()()). I once thought that since s[0] and s[1] is valid now like ()()), we don't need to change s[0]+s[1] in later steps. But in fact it is not true, s[1] is still possible to be deleted in later steps, and the right logic should be: once a ")" is deleted, we should restart from i=0, j=0 to look for the invalid ")" and do the recursion, and check those duplicates, this is the right way to find all possible answers, just like in the above example, in the second recursion in principle we should start looking for redundant ")" from i=0, j=0, and take care there will be duplicates { which means that working on ()()) and find i=4, j=1, string is like ()()), and then delete this s[j] }. If we start from i=2, j=2, some answers will be missed. Fortunately, we don't need to restart from i=0, j=0 for each recursion, since all possible transformation before last_ j has been covered in previous recursions, { but all possible transformations in range [ last_ j, last_i ] are not, take another example, ()()r)), first recursion can cover ()()r)), ()()r)), but won't cover ()()r)) } , we just need to restart from j = last_ j. That's why last_ j is necessary. On the other hand, value i can restart from last_i, too. I kind of like thinking of that the reason of choosing i and j are independent to each ....

    // next recursion starts from i, not i+1
    // as mentioned by somebody before, since 1 char is deleted, index i is automatically advanced one position.
    public void remove(String s, int last_i, int last_j,  char[] par) {
        // go through every char in s
        for (int stack = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                // if cur char is closing bracket
                if (s.charAt(j) == par[1] 
                    // don't add if it's a duplicate (prev char is also a closing bracket) since we already counted it prev iteration unless cur is the first char in this iteration with j (in this case even if pre is a duplicate it could've been swapped already by the prev iteration with i)
                    && (j == last_j 
                        || s.charAt(j - 1) != par[1])) {
                    // remove this char, then run the same function with the char removed
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        // finished left to right
        if (par[0] == '(') remove(reversed, 0, 0, new char[]{')', '('});
        // finished right to left
        else result.add(reversed);
    }
}