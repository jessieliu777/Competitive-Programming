class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // count[str] = number of times str occurs in words
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), wordsCount = words.length, wordLength = words[0].length();
        
        // for every possible position of i.  All the strings of words are of the same length so the last i is always n - words.length*words[0].length
        for (int i = 0; i < n - wordsCount * wordLength + 1; i++) {
            // seen[str] = number of times str is seen in this iteration
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < wordsCount) {
                final String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                // Once we meet an unexpected word or the times of some word is larger than its count in words[], we stop the check. 
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            // If we finish the check successfully, push i to the result indexes.
            if (j == wordsCount) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}