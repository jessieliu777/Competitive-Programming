class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++)
            {
                if (words[i].equals(new StringBuilder(words[j]).reverse().toString())) result++;
            }
        }
        return result;
    }
}