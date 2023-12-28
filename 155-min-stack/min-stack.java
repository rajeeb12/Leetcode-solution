class Pair{
    int num;
    int min;
    public Pair(int _n,int _m)
    {
        this.num = _n;
        this.min = _m;
    }
}
class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
        {
            st.add(new Pair(val, val));
        }else{
            int min = Math.min(st.peek().min, val);
            st.add(new Pair(val, min));
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        return st.peek().num;
    }
    
    public int getMin() {
        if(st.isEmpty()) return -1;
        return st.peek().min;
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