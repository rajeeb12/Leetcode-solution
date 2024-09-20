class Solution {
    public String shortestPalindrome(String s) {
        String rev = "";
        int n = s.length();
        for(int i = n - 1; i >= 0; i--){
            rev += s.charAt(i);
        }
        if(s.equals(rev)) return s;
        int si = n - 1;
        for(int i = 0; i < n; i++)
        {
            String substr = s.substring(0, n - i);
            String rsubstr = rev.substring(i, n);

            if(substr.equals(rsubstr))
            {
                return rev.substring(0, i) + s;
            }
        }
        return "";
    }
}