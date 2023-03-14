class Solution {
    public int[] diStringMatch(String s) {
        int len = s.length(), left = 0, right = len;
        int[] res = new int[len + 1];
        // for every char in s if it's increasing then we take the next smallest char (left)
        // if decreasing then take the next largest char (right)
        for (int i = 0; i < len; i++) res[i] = s.charAt(i) == 'I' ? left++ : right--;
        // pad the last digit, which at the end of the loop left = right 
        // so set res[len] to left or right doesn't really matter
        res[len] = left;
        return res;
    }
}