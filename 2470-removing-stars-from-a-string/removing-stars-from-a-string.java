class Solution {
    public String removeStars(String s) {
        Stack<Character> st= new Stack<>();

        for(char ch: s.toCharArray())
        {
            if(ch == '*')
            {
                if(st.isEmpty()) continue;
                else{
                    st.pop();
                }
            }
            else{
                st.add(ch);
            }
        }
        String ans = "";
        while(!st.isEmpty())
        {
            ans = st.pop() + ans;
        }
        return ans;
    }
}