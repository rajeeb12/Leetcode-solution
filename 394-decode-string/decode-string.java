class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()){
            if(c != ']'){
                st.add(c);
            }else{
                String substr = "";
                while(!st.isEmpty() && st.peek() != '['){
                    substr = st.pop() + substr;
                }
                st.pop();
                String num = "";
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    num = st.pop() + num;
                }
                
                String finalStr = "";
                for(int i = 0; i < Integer.parseInt(num); i++){
                    finalStr += substr; 
                }
                for(char ch: finalStr.toCharArray()){
                    st.add(ch);
                }
            }
        }
        StringBuilder ans = new StringBuilder("");
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}