class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        // If the string s has repeated block, it could be described in terms of pattern.
        // S = bb (For example, S has two repeatable block at most)
        // If we repeat the string, then SS=bbbb.
        // Destroying first and the last pattern by removing each character, we generate a new S2=?bb?.

        // The maximum length of a "repeated" substring that you could get from a string would be half it's length
        // For example, s = "abcdabcd", "abcd" of len = 4, is the repeated substring.
        // You cannot have a substring >(len(s)/2), that can be repeated.

        // So, when ss = s + s , we will have atleast 4 parts of "repeated substring" in ss.
        // (s+s)[1:-1], With this we are removing 1st char and last char => Out of 4 parts of repeated substring, 2 part will be gone (they will no longer have the same substring).
        // ss.find(s) != -1, But still we have 2 parts out of which we can make s. And that's how ss should have s, if s has repeated substring.

        // now for the converse pf by induction:
        // base case: If length a and b are both 1, then it's obvious a and b are equal and the common substring is itself.
        // IH: if two strings a, b satisfies ab = ba, then both a and b are repeated string of an common substring.
        // IS: Suppose the IH holds for length of a and b <= n.
        // For the case of length of a and b longer than n. Since ab = ba, supposing a is longer, then we can have another string c, such that a = bc. Inserting this into ab=ba, we have bcb=bbc. Removing the leading b we have cb=bc. If length of c is less than n, we know b and c are repeated string of an common substring, and so does a=bc. If length of is still larger than n, we can keep doing this process until the length is less than n.

        // Now return to the original problem. If the string S in T=(S+S)[1,-1], then the substr contains s must cross the middle char, because half of T is shorter than the original S after removing the first and last character. For example T = ...b (middle point) a... and ba is the matching part to S, which is to say S=ba. And also we know S=ab since b is from the right part of S and a is from the left part of S. Therefore S is periodic.
        return str.substring(1, str.length() - 1).contains(s);
    }
}