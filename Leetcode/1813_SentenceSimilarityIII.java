class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" "), words2 = sentence2.split(" ");
        int i = 0, n1 = words1.length, n2 = words2.length;
        if (n1 > n2) return areSentencesSimilar(sentence2, sentence1);
        while (i < n1 && words1[i].equals(words2[i])) i++;
        while (i < n1 && words1[i].equals(words2[n2 - n1 + i])) i++;
        return i == n1;
    }
}