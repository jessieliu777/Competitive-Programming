class Solution {
    public String orderlyQueue(String s, int k) {
        // if k >= 2 then we can swap any 2 adj elements 
        // for example if we want to swap x_i, x_{i+1} in x_1,...x_i,x_{i+1},...,x_n
        // move the first element to the end i-1 times, becomes x_i, x_{i+1},...,x_n, x_1,...,x_{i-1}
        // since k >= 2 then we can move any 1 of x_i, x_{i+1}, choose the latter first then move x_i
        // move the remaining elements all the way to x_n, so we are back to the original array except x_i, x_{i+1} is swapped
        // since swapping adj elements can be done for any elements, then it's like bubble sort we can obtain a sorted string
        if (k > 1){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        } else {
            // have a string that's s+s
            // now every possible rotation would've been a substring of s+s
            // so we just need a sliding window to go through every substring
            // keep the 'smallest' substring lexicographically
            String sTwice = s + s;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                String tmp = sTwice.substring(i, i + len);
                s = (s.compareTo(tmp) > 0) ? tmp : s;
            }
            return s;
        }
    }
}