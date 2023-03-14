class Solution {
    public int findTheLongestSubstring(String s) {
        // count = the count of "aeiou"
        // count & 1 = the records of a % 2
        // count & 2 = the records of e % 2
        // count & 4 = the records of i % 2
        // count & 8 = the records of o % 2
        // count & 16 = the records of u % 2
        // Note that we don't really need the exact count number, we only need to know if it's odd or even.
        int res = 0 , count = 0, len = s.length();
        HashMap<Integer, Integer> firstVowelIndex = new HashMap<>();
        firstVowelIndex.put(0, -1); // first occurence of no vowels is DNE before we start at index 0 (basically the first occurence of no vowels at cur char = DNE is DNE, denoted by -1)
        for (int i = 0; i < len; i++) {
            // count ^= 1 << 'aeiou'.find(c) will toggle the count of c.
            // for no vowel characters,'aeiou'.find(c) will return -1, so need to padd the +1, and then do right shift
            // Note: a ^ b = 1 iff a != b for bits a, b <=> a ^ b = 0 iff a == b
            // when cur char is one of aeiou, and there is an odd number of aeiou already, then count[i+1] used to be 1 but 1^1 is 0 so it gets toggled to 0
            // same logic for other 3 cases, the line below toggles the count % 2
            count ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1 ) >> 1;
            // if we didn't already have the first occurence of count then this is the first occurence
            firstVowelIndex.putIfAbsent(count, i);
            // the max len substring is the length from the first occurence to cur char
            res = Math.max(res, i - firstVowelIndex.get(count));
        }
        return res;
    }
}