class Solution {
    public String removeKdigits(String num, int k) {
      
        Stack<Integer> st = new Stack<>();

        for(char c: num.toCharArray()){
            
            int n = c - '0';
            while(!st.isEmpty() && st.peek() > n && k > 0){
                st.pop();
                k--;
            }
            if(!st.isEmpty() || n != 0) st.add(c-'0'); // empty hai and then n == 0 avoid this.
        }

        while(!st.isEmpty() && k > 0)
        {
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}