class Solution {
    public int evalRPN(String[] tokens) {
        // The Reverse Polish Notation is a stack of operations, so use java.util.Stack to solve this problem
        // Add every token as an integer in the stack, unless it's an operation. For operations, pop two elements from the stack and then save the result back to it. 
        // After all operations are done through, the remaining element in the stack will be the result.
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			if(token.equals("+")) stack.add(stack.pop() + stack.pop());
            else if(token.equals("*")) stack.add(stack.pop() * stack.pop());
			else if(token.equals("/")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(a / b);
			}
			else if(token.equals("-")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(a - b);
			}
			else stack.add(Integer.parseInt(token));
		}	
		return stack.pop();
    }
}