class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // sort by words by word length
        Arrays.sort(words, (w1, w2) -> (w1.length() - w2.length()));
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        // for every word in words
        for (String word : words) {
            int len = word.length();
            // dp[i] = true iff word[0,i] is a concatenated word
            boolean[] dp = new boolean[len + 1];
            // edge case: empty str is a concatenated word to make the algo easier but by def of the qestion it should not be. Set it to true for now, and make sure to not add empty str to final ans
            dp[0] = true;
            // for every char in word
            for (int i = 1; i <= len; i++) {
                // we want to check every substring of word <=> every possible word[j, i] for 1 <= j <= i
                for (int j = i; j > -1; j--) {
                    // if word[0,j] is a concat word then word[0, i] is a concat word iff word[j, i] is a word given in words (we've added all the words to set in word length order so it must be there)
                    if (dp[j] && set.contains(word.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            // add all nonempty concat words to ans and set
            if (len > 0 && dp[len]) ans.add(word);
            set.add(word);
        }
        return ans;
    }
}