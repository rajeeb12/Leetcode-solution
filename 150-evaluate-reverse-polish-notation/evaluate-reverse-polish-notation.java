class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(String str: tokens)
        {
            if(st.size() >=2 && str.equals("+"))
            {
                int add = st.pop() + st.pop();
                st.add(add);
            }else if(st.size() >=2 && str.equals("-"))
            {
                int y = st.pop();
                int sub =  st.pop() - y;
                st.add(sub);
            }else if(st.size() >=2 && str.equals("/"))
            {
                int y = st.pop();
                int divide =  st.pop() / y;
                st.add(divide);

            }else if(st.size() >=2 && str.equals("*")){
                int mul = st.pop() * st.pop();
                st.add(mul);
            }else{
                st.add(Integer.parseInt(str));
            }
        }
        return st.pop();
    }
}