class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        char first = (x > y ? 'a' : 'b');
        char second = (x > y ? 'b' : 'a');
        int min = Math.min(x, y);
        int max = Math.max(x,y);
        int ans = 0;
        for(char c: s.toCharArray())
        {
            if(c == second)
            {
                if(!st.isEmpty() && st.peek() == first)
                {
                    ans += max;
                    st.pop();
                }else{
                    st.add(c);
                }
            }else{
                st.add(c);
            }
        }
        Stack<Character> st2 = new Stack<>();
        while(!st.isEmpty()){
            char c = st.pop();
            if(!st2.isEmpty() && st2.peek() == first && c == second){
                ans += min;
                st2.pop();
            }else{
                st2.add(c);
            }
        }
        return ans;
    }
}