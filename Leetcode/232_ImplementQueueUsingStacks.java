class MyQueue {
    private Stack<Integer> in_stk = new Stack<>();
    private Stack<Integer> out_stk = new Stack<>();
    public MyQueue() {
        in_stk = new Stack<>();
        out_stk = new Stack<>();
    }
    
    public void push(int x) {
        in_stk.push(x);
    }
    
    // Remove the element from the front of the queue and returns it
    public int pop() {
        peek();
        return out_stk.pop();
    }
    
    public int peek() {
        if (out_stk.isEmpty())
        while (!in_stk.isEmpty())
            out_stk.push(in_stk.pop());
        return out_stk.peek();
    }
    
    public boolean empty() {
        return in_stk.isEmpty() && out_stk.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */