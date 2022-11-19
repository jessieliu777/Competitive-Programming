class MinStack {
    Stack<Integer> stack;
    int min;

    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        // if val is equal or less than min value then push old min value first, and update min value to be val
        if(val <= min){          
            stack.push(min);
            min=val;
        }
        stack.push(val);
    }
    
    public void pop() {
        // if min value is popped then we need another min value, so pop twice
        if(stack.pop() == min) min=stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */