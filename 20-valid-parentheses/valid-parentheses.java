class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                st.add(c);
            }else{
                if(c == ')'){
                    if(st.isEmpty() || '(' != st.peek()) return false;
                }else if(c == ']'){
                    if(st.isEmpty() || '[' != st.peek() ) return false;
                }else if(c == '}'){
                    if(st.isEmpty() || '{' != st.peek()) return false;
                }
                st.pop();
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}