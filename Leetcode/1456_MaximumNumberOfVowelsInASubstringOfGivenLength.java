class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        // Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        var vowels = Set.of('a', 'e', 'i', 'o', 'u'); // Java 11 Collection factory method
        // sliding window of size k ending at i. since window size is fixed one end pointer i is enough, as start is simply i-k when i goes above k
        for (int i = 0, count = 0; i < s.length(); i++) {
            // if the new char that got added to the window is a vowel then increment count
            if (vowels.contains(s.charAt(i))) count++;             
            // if the char that got kicked out of the cur window is a vowel then it's not counted in cur window
            if (i >= k && vowels.contains(s.charAt(i - k))) count--;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}