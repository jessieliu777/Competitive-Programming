class Solution {
    public String reorganizeString(String s) {
        // count letter appearance and store in hash[i]
        // find the letter with largest occurence.
        int[] hash = new int[26];
        int max = 0, letter = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            int cur = s.charAt(i) - 'a';
            if (++hash[cur] > max) {
                max = hash[cur];
                letter = cur;
            };
        }

        // clearly if max occurence > (len+1)/2 then there's not enough even indices, so for that return empty str as wanted
        if (max > (len + 1) / 2) return ""; 

        // put the letter with max occurence into even index number (0, 2, 4 ...) char array
        char[] res = new char[len];
        int idx = 0;
        while (hash[letter]-- > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
        }

        // put the rest into the array
        for (int i = 0; i < hash.length; i++) {
            while (hash[i]-- > 0) {
                // continuing on from putting max occurence letter into even indices, if there are left over even indices keep finish them
                // when all the even indices are filled, do the odd indices by setting idx to 1
                if (idx >= res.length) idx = 1;
                res[idx] = (char) (i + 'a');
                idx += 2;
            }
        }
        return String.valueOf(res);
    }
}