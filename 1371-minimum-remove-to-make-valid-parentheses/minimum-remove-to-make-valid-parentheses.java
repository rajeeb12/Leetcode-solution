class Pair{
    char c;
    int i;
    public Pair(char _c,int _i)
    {
        this.c = _c;
        this.i = _i;
    }
}
class Solution {
    public String minRemoveToMakeValid(String s) {
    
        Stack<Pair> st = new Stack<>();
        HashSet<Integer> invalid = new HashSet<>();
        int n = s.length();
        
        for(int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                st.add(new Pair(c, i));
            }else if(c == ')')
            {
                if(st.isEmpty())
                {
                    invalid.add(i);
                    continue;
                }else{
                    st.pop();
                }
            }
        }
        while(!st.isEmpty())
        {
            Pair p = st.pop();
            invalid.add(p.i);
        }
        String ans = "";
        for(int i = 0; i < n; i++)
        {
            if(invalid.contains(i)) continue;
            ans += s.charAt(i);
        }
        return ans;
    }
}