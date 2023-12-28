class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.add(x);
    }
    
    public int pop() {
        if(output.isEmpty())
        {
            while(!input.isEmpty()) output.add(input.pop());
        }

        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty())
        {
            while(!input.isEmpty()) output.add(input.pop());
        }

        return output.peek();
    }
    
    public boolean empty() {
        if(output.isEmpty()){
            while(!input.isEmpty()) output.add(input.pop());
        }

        return output.isEmpty();
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