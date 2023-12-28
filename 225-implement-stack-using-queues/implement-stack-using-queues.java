class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        int size = q.size() - 1;
        while(size != 0)
        {
            q.add(q.poll());
            size--;
        }
    }
    
    public int pop() {
        if(q.isEmpty()) return -1;
    
        return q.poll();
    }
    
    public int top() {
        if(q.isEmpty()) return -1;
        return q.peek();
    }
    
    public boolean empty() {
        return (q.isEmpty() == true ? true: false);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */