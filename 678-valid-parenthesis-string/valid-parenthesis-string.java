class Solution {
    public boolean checkValidString(String s) {
        int l = 0, r = 0;
        for(char c: s.toCharArray())
        {
            if(c == '(')
            {
                l++;
                r++;
            }else if(c == ')'){
                l--;
                r--;
            }else{
                l--;
                r++;
            }
            if(r < 0)
            {
                return false;
            }
            if(l < 0)
            {
                l = 0;
            }
        }
        return l == 0;
    }
}