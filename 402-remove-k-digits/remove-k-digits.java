class Solution {
    public String removeKdigits(String s, int k) {
        Stack<Integer> st = new Stack<>();

        for(char ch: s.toCharArray())
        {
            int num = ch - '0';

            while(!st.isEmpty() && k > 0 &&  st.peek() > num)
            {
                st.pop();
                k--;
            }

            if(!st.isEmpty() || num != 0) st.add(num);
        }
        String ans = "";
        // remove the largest value from the top
        while(!st.isEmpty() && k > 0)
        {
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        for(int i: st)
        {
            ans = ans + i;
        }
        return ans;

    }
}