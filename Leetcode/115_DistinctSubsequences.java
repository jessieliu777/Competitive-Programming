class Solution {
    public int numDistinct(String s, String t) {
        // memo[i+1][j+1] = the number of distinct subsequences s[0..j] which equals t[0..i] 
        // => Therefor the result will be memo[t.length()][s.length()].
        int[][] memo = new int[t.length()+1][s.length()+1];

        // for all j, memo[0][j] = 1 because the empty string is a subseq of any string but only 1 time. 
        // => if t is an empty string, the answer is 1 anyways, so we would still return the correct value
        // filling the first row: with 1s
        for(int j=0; j<=s.length(); j++) memo[0][j] = 1;
        
        // for all i>0, memo[i][0] = 0 because an empty string cannot contain a non-empty string as a substring
        // mem[0][0] = 1, because an empty string contains the empty string 1 time.
        // we don't need to initialize like above since all non-initizlied values are default to 0 anyways

        // for every char in t
        for(int i=0; i<t.length(); i++) {
            // for every char in s
            for(int j=0; j<s.length(); j++) {
                // if cur char of t is not the same as cur char of s 
                // then we have the same number of distinct subsequences as we had without the cur char
                // => the number of distinct subsequences s[0..j] which equals t[0..i] is the same as
                // memo[i+1][j] = the number of number of distinct subsequences s[0..j-1] which equals t[0..i] 
                memo[i+1][j+1] = memo[i+1][j];
                // if cur char of t is the same as cur char of s
                // then the number of distinct subsequences is the number we had without cur char (<=> the number of distinct subseqs of t before we get to cur char of s) PLUS the number of distinct subsequences using cur char (<=> the number of distinct subseqs of s[0..i-1] which equals t[0..j-1] (=memo[i, j]) * the number of distinct subseqs of s[i] which equals t[j] (=1) <=> memo[i, j] * 1 <=> memo[i, j])
                // then the number of distinct subsequences s[0..j] which equals t[0..i] is
                // memo[i+1][j] = the number of number of distinct subsequences s[0..j-1] which equals t[0..i] 
                // + memo[i][j] = the number of number of distinct subsequences s[0..j-1] which equals t[0..i-1]
                // for example: s: [acdabefbc] and t: [ab]
                // first outer loop iteration i=0, t[0] = 'a', so check with a:
                //          s = [acdabefbc], 
                // memo[1,:] = [0111222222]
                // at i=0, j=0 since s[0] = t[0] is the very first occurence of 'a' -> memo[1, 1] = 1
                // the empty string contains t[0] = 'a' 0 times, s[0] contains the empty string 1 time
                // => memo[1, 0] = 1, memo[0, 0] = 0 -> memo[1, 1] = 0 + 1 = 1 as wanted

                // at i=0, j=3, we reach a second 'a'. s = [acda], so there are 2 distinct subseq of s which equals 'a' (the first 'a' and the last 'a') -> memo[1, 4] = 2
                // s[0, 2] = [acd] contains 'a' 1 times, s[0, 3]= [acda] contains the empty string 1 time
                // => memo[1, 2] = 1, memo[0, 2] = 1 -> memo[1, 3] = 1 + 1 = 2 as wanted

                // second outer loop iteration i=1, t[0, 1] = 'ab', so check with ab:
                //         s = [acdabefbc]
                // mem[1,:] = [0111222222] (unchanged from 1st iteration)
                // mem[2,:] = [0000022244]

                // since in both cases we need +memo[i+1][j], we just need an if statement to append the +memo[i][j] which is not added to the non equal case
                if(t.charAt(i) == s.charAt(j)) memo[i+1][j+1] += memo[i][j];
                
            }
        }
        return memo[t.length()][s.length()];
    }
}