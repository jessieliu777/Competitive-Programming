class Solution {
    public String crackSafe(int n, int k) {
        // Initialize pwd to n repeated 0's as the start node of DFS.
        String strPwd = String.join("", Collections.nCopies(n, "0"));
        StringBuilder sbPwd = new StringBuilder(strPwd);
        Set<String> visitedComb = new HashSet<>();
        visitedComb.add(strPwd);
        // In order to guarantee to open the box at last, 
        // the input password ought to contain all length-n combinations on digits [0..k-1] -> there should be k^n combinations in total.

        // To make the input password as short as possible, we'd better make each possible length-n combination on digits [0..k-1] occurs exactly once as a substring of the password. The existence of such a password is proved by De Bruijn sequence:

        // A de Bruijn sequence of order n on a size-k alphabet A is a cyclic sequence in which every possible length-n string on A occurs exactly once as a substring. It has length k^n, which is also the number of distinct substrings of length n on a size-k alphabet; de Bruijn sequences are therefore optimally short.

        int targetNumVisited = (int) Math.pow(k, n);
        crackSafeAfter(sbPwd, visitedComb, targetNumVisited, n, k);
        return sbPwd.toString();
    }
    
    private boolean crackSafeAfter(StringBuilder pwd, Set<String> visitedComb, int targetNumVisited, int n, int k) {
        // Base case: all n-length combinations among digits 0..k-1 are visited. 
        if (visitedComb.size() == targetNumVisited) return true;
        
        // given in question for any sequence enters, only the most n digits count
        // so we need the last n-1 digits of cur sequence and try out every possible char from 0 to k to try out a new n length seq
        String lastDigits = pwd.substring(pwd.length() - n + 1); // Last n-1 digits of pwd.
        // for every char from 0 to k
        for (char ch = '0'; ch < '0' + k; ch++) {
            // try the seq last last n-1 digits + cur char
            String newComb = lastDigits + ch;
            // if this combo isnt already tried
            if (!visitedComb.contains(newComb)) {
                // then try the combo
                visitedComb.add(newComb);
                pwd.append(ch);
                // if we can crack safe by adding cur char to password then we are done
                if (crackSafeAfter(pwd, visitedComb, targetNumVisited, n, k)) return true;
                // if not then the password is some seq where cur char isn't added rn, so we should remove it
                visitedComb.remove(newComb);
                pwd.deleteCharAt(pwd.length() - 1);
            }
        }
        return false;
    }
}