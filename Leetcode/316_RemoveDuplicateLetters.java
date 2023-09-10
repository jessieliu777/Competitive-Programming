class Solution {
    public String removeDuplicateLetters(String s) {
         // lastIndex[i] = last index ith char is present
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) lastIndex[s.charAt(i) - 'a'] = i;
        // seen[i] = whether ith char is seen or not
        boolean[] seen = new boolean[26];
        Stack<Integer> st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            // skip if we've already seen as this is duplicate
            if (seen[curr]) continue;
            // otherwise check if the last stack char is lexicographically higher, if so and there is some duplicate in the future, then pop it, since we can just add it in some later iteration with a smaller lexicograph order. Once it removed from stack they are no longer 'seen' in stack
            while (!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]){
                seen[st.pop()] = false; // pop out and mark unseen
            }
            // push curr to stack, mark it as seen
            st.push(curr);
            seen[curr] = true;
        }
        // after the st process is done, convert to str. Since stack is LIFO, need to reverse
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();
    }
}