class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        st.add(s.charAt(0));

        for(int i = 1; i < s.length(); i++)
        {
            if(!st.isEmpty() && (s.charAt(i) == 'B' && st.peek() =='A' || s.charAt(i) == 'D' && st.peek() =='C')){
                st.pop();
                continue;
            }
            st.add(s.charAt(i));
        }
        
        return st.size();
    }
}