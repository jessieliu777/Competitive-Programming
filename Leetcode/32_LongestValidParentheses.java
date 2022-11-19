class Solution {
    public int longestValidParentheses(String s) {
        int maxlength = 0;
        int left = 0, right = 0; // left = number of left brackets, same with right
        // for every char, get the longestValidParenthese starting from the left
        for (int i = 0; i < s.length(); i++){
            // if the current bracket is left or right, increment accordingly
            if (s.charAt(i) == '(') left++;
            else right++;            
            // if there's equal amount of left and right brackets then we have a well formed parenthesis substring
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        // for every char, get the longestValidParenthese starting from the right
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}