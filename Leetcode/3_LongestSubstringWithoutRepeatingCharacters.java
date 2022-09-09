class Solution {
    public int lengthOfLongestSubstring(String s) {
        // for every sub string starting from the last char
        // have a hashmp that maps each char to the furthest index
        int len = s.length();
        int result = 0;
        if (len > 0){
            HashMap<Character, Integer> map = new HashMap<>();
            result = 1;
            map.put(s.charAt(0), 0);
            // have two iterators i, j denote the index of the longest substring
            for (int i = 1, j=0; i < len; i++){
                // if the index is already in the map
                if (map.containsKey(s.charAt(i))){
                    // update j to be the index right next to i. O/w, leave j where it is
                    j = Math.max(j,map.get(s.charAt(i))+1);
                }
                // update map
                map.put(s.charAt(i), i);
                result = Math.max(result, i-j+1);
            }
        }
        return result;
    }
}