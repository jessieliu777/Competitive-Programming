class Solution {
    public String removeStars(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray())
            // if it's a star, remove the last added char (which is the leftest non-star char)
            if (c == '*') res.setLength(res.length() - 1);
            else res.append(c);
        return res.toString();
    }
}