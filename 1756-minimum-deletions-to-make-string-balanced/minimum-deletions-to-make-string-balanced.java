class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(char c: s.toCharArray()){
            if(!st.isEmpty() && c == 'a' && st.peek() == 'b'){
                st.pop();
                count++;
            }else{
                st.add(c);
            }
        }
        return count;
    }
}