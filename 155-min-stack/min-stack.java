class Pair{
    int num;
    int min;
    public Pair(int _num,int _min){
        this.num = _num;
        this.min = _min;
    }
}
class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.add(new Pair(val, val));
        }else{
            int min = Math.min(st.peek().min, val);
            st.add(new Pair(val, min));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return (!st.isEmpty() ? st.peek().num : -1);
    }
    
    public int getMin() {
        return (!st.isEmpty() ? st.peek().min : -1);
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