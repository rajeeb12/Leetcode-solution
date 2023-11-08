class Solution {
    public String removeOuterParentheses(String s) {
        // using counter when ( hua hai toh +1 else -1

        String res ="";
        int count = 0, si= 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                res += s.substring(si + 1, i);
                si = i + 1;
            }
        }
        return res;
    }
}