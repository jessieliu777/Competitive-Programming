class Solution {
    public List<String> letterCasePermutation(String s) {
        LinkedList<String> result = new LinkedList<>();
        result.add(s);
        // for every char in s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if it s a letter
            if (Character.isLetter(c))
                // for every resulting str we have so far
                for (int size = result.size(); size > 0; size--) {
                    // add the new result with same str except with lower cur char & same w/ upper cur char
                    String cur = result.poll(), left = cur.substring(0, i), right = cur.substring(i + 1);
                    result.add(left + Character.toLowerCase(c) + right);
                    result.add(left + Character.toUpperCase(c) + right);
                }
        }
        return result;
    }
}