class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray())
        {
            if(ch == '(' || ch=='[' || ch == '{')
            {
                st.add(ch);
            }else{
                if(st.isEmpty()) return false;
                if(ch == ')')
                {
                    if( st.peek() != '(') return false;
                    st.pop();
                }else if(ch == ']')
                {
                    if(st.peek() != '[') return false;
                    st.pop();
                }else{
                    if(st.peek() != '{') return false;
                    st.pop();
                }
            }
        }
        return (st.size() == 0 ? true: false);
    }
}