class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray())
        {
            if(ch == ']')
            {
                String substr = "";
                while(!st.isEmpty() && st.peek() != '[')
                {
                    substr = st.pop() + substr;
                }
                st.pop();
                String k ="";
                while(!st.isEmpty() && Character.isDigit(st.peek()))
                {
                    k = st.pop() + k;
                }
                int count = Integer.valueOf(k);
                while(count-- > 0)
                {
                    for(char ch1: substr.toCharArray())
                    {
                        st.add(ch1);
                    }
                }
            }
            else
            {
                st.add(ch);
            }
        }
        String ans ="";
        while(!st.isEmpty())
        {
            ans = st.pop() + ans;
        }
        return ans;
    }
}