class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                if(!st.isEmpty()) st.pop();
            }
            else st.add(c);
        }
        String ans = "";

        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}