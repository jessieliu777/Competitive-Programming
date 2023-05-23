class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0; // value = bin int where kth bit is on iff the kth alphabet is in cur word
            for (int j = 0; j < tmp.length(); j++) {
                // 1 << (tmp.charAt(j) - 'a') = the bin int where kth bit is on iff cur char is the kth alphabet. Without the 1 << part, it will be off by 1 as 'a' - 'a' = 0
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        // compare every pair of word, if they share no alphabet, that is there is no such k such that the kth alphabet is in both words, which also means no such k st kth bit is on in both values => value[i] & value[j]) == 0. In this case update maxProduct if it's exceeded cur maxProduct
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0) maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);
            }
        return maxProduct;
    }
}