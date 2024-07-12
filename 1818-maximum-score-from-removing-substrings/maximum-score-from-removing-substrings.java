class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        char first = (x > y ? 'a' : 'b');
        char second = (x > y ? 'b' : 'a');
        int ans = 0;
        for(char c: s.toCharArray())
        {
            if(c == second)
            {
                if(!st.isEmpty() && st.peek() == first)
                {
                    ans += (x > y ? x : y);
                    st.pop();
                }else{
                    st.add(c);
                }
            }else{
                st.add(c);
            }
        }
        String str = "";
        while(!st.isEmpty()){
            char c = st.pop();
            str = c + str;
        }

        return ans + solve(str, (x > y ? y : x), x, y);
    }
    public int solve(String s, int points,int x,int y)
    {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        char first = (x < y ? 'a' : 'b');
        char second = (x < y ? 'b' : 'a');
        for(char c: s.toCharArray())
        {
            if(c == second)
            {
                if(!st.isEmpty() && st.peek() == first)
                {
                    ans += points;
                    st.pop();
                }else{
                    st.add(c);
                }
            }else{
                st.add(c);
            }
        }
        return ans;
    }
}