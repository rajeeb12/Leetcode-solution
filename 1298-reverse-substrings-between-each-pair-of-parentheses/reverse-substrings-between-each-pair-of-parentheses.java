class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()){
            if(c ==')'){
                String temp ="";

                while(st.peek() != '('){
                    temp += st.pop();
                }
                st.pop();

                for(char t: temp.toCharArray()){
                    st.add(t);
                }
            }else{
                st.add(c);
            }
        }
        String ans ="";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}