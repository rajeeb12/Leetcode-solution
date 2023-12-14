class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        int start = 0;
        String res = "";

        for(int i = 0 ; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                count++;
            }else{
                count--;
            }
            if(count == 0)
            {
                res += s.substring(start + 1, i);
                start = i + 1;
            }
        }
        return res;
    }
}