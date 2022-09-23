class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            // if char in s is already mapped to a different char in t, then not isomorphic
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) return false;
            // if char in t is already mapped to a different char in s, then not isomorphic
            if (!map.containsKey(s.charAt(i)) && set.contains(t.charAt(i))) return false;
            // map char in s to char in t
            map.put(s.charAt(i), t.charAt(i));
            // add the chars we've mapped to set so we know which ones are already mapped
            set.add(t.charAt(i));
        }
        return true;
    }
}