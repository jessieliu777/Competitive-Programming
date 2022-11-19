class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        dp = new Boolean[sLen][pLen];
        return is_match(s, p, sLen-1, pLen-1);
    }
    
    private boolean is_match(String s,String p, int sIndex, int pIndex){
        //Base Case
        //if m and n have no chars left then they match
        if (pIndex < 0 && sIndex < 0) return true;
        // if n has leftovers while m doesn't then no match
        if (pIndex < 0 && sIndex >= 0) return false;
        
        // if pIndex has some character but n is empty
        if (sIndex < 0 && pIndex >= 0) {
            // if str = ""  && p has something else besides * then no match
            for (int i=0;i<=pIndex;i++){
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }
        
        //Memorisation
        if (dp[sIndex][pIndex] != null) return dp[sIndex][pIndex];
        //if both the character is equal || pattern[pIndex] == ?
        else if (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '?'){
            return dp[sIndex][pIndex] = is_match(s, p, sIndex-1, pIndex-1);
        }
        // if p has '*'
        else if (p.charAt(pIndex) == '*'){
            return dp[sIndex][pIndex] = is_match(s, p, sIndex, pIndex-1) || is_match(s, p, sIndex-1, pIndex);
        }
        else return false;
    }
}