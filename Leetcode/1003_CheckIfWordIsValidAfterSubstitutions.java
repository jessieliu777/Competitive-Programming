class Solution {
    public boolean isValid(String s) {
        // -- sol using replace
        // String abc = "abc";
    	// while(s.contains(abc)) s = s.replace(abc, "");
        // return S.isEmpty();

        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }
}