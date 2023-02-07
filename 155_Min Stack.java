class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();    
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
        stack.push(val);
    }
    
    public void pop() {
        if(minStack.peek().equals(stack.peek())) minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
