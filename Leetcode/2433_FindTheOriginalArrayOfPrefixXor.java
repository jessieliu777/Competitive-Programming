class Solution {
    public int[] findArray(int[] pref) {
        // The reverse operation of + is -
        // The reverse operation of ^ is still ^
        // Hence result[i] = result[i-1] ^ pref[i] => result[i] ^ result[i-1] = pref[i]
        for (int i = pref.length - 1; i > 0; i--) pref[i] ^= pref[i - 1];
        return pref;
    }
}