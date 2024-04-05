class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        if(s.length() == 0 || s.length() == 1) return s;
        int n = s.length();
        for(int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            if( !st.empty() && ((Character.isLowerCase(c) && Character.isUpperCase(st.peek())) || (Character.isLowerCase(st.peek()) && Character.isUpperCase(c))) ){
                char c1 = Character.toLowerCase(c);
                char c2 = Character.toLowerCase(st.peek());
                if(c1 == c2)
                {
                    st.pop();
                    continue;
                } 
            }
            st.add(c);
        }
        StringBuilder ans = new StringBuilder("");
        for(char c: st)
        {
            ans.append(c);
        }
        return ans.toString();
    }
}