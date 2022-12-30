class Solution {
    public boolean checkIfPangram(String sentence) {
        int seen = 0; // we started with 0 as all bits are 0, denoting no alphabet has occurred till now
        // then we iterate over all characters of input, and change them to integer value of 0 to 25
        for(char c : sentence.toCharArray()) {
            // 'a' - 'a' = 97 - 97 (ASCII values) = 0
            // 'b' - 'a' = 98 - 97 = 1
            // 'c' - 'a' = 99 - 97 = 2
            // .
            // .
            // 'z' - 'a' = 122 - 97 = 25
            int ci = c - 'a';
            // here << is bitwise left-shift operator which will shift the 1st bit of 1 to left by ci places.
            // 1 << ci will denote , for,
            // a -> 00....00001
            // b -> 00....00010
            // c -> 00....00100
            // d -> 00....01000
            // and so on...

            // now you can see when we take OR with seen then the respective position bit will become 1
            // which is used to indicate this alphabet has occurred.

            seen = seen | (1 << ci);
        }
        return seen == ((1 << 26) - 1);
    }
}