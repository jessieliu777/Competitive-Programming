class Solution {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()) set.add(ch);
        // go thru each char from z to a, if both upper and lower is in set then return it as upper
        for(char ch = 'Z'; ch >= 'A'; ch--) if(set.contains(ch) && set.contains((char)('a'+(ch-'A')))) return Character.toString(ch);
        return "";
    }
}