/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        // base case no ints
        if (s.isEmpty()) return null;
        // base case non nested
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        // left shall point to the start of a number substring; 
        // right shall point to the end+1 of a number substring
        int left = 0; 
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (ch == '[') {
                // push the prev nest if there is
                if (curr != null) stack.push(curr);
                // start recording cur nest from right onwards
                curr = new NestedInteger();
                left = right+1;
            } else if (ch == ']') {
                // get the potential cur num
                String num = s.substring(left, right);
                // if it exists, add the num to cur nest
                if (!num.isEmpty()) curr.add(new NestedInteger(Integer.valueOf(num)));
                // pop the prev nest if there is
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    // the prev nest should store cur in its nest, since if it exists it's not closed, now the merged big nest is the cur nest
                    pop.add(curr);
                    curr = pop;
                }
                left = right+1;
            } else if (ch == ',') {
                // if the lhs of , isn't a nest, it must be a number, so add it to the nest
                if (s.charAt(right-1) != ']') {
                    String num = s.substring(left, right);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                left = right+1;
            }
        }
        
        return curr;
    }
}