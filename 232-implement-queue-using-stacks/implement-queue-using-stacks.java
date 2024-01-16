class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        while(!input.isEmpty())
        {
            output.add(input.pop());
        }

        input.add(x);
        while(!output.isEmpty()) input.add(output.pop());
    }
    
    public int pop() {
        if(input.isEmpty()) return 0;

        return input.pop();
    }
    
    public int peek() {
        if(input.isEmpty()) return 0;

        return input.peek();
    }
    
    public boolean empty() {
        return input.isEmpty();
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