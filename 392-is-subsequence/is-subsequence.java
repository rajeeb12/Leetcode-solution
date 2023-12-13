class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int count = 0;

        for(int i = 0 ; i < t.length(); i++)
        {
            if(p1 < s.length() && t.charAt(i) == s.charAt(p1))
            {
                count++;
                p1++;
            }
        }
        if(count == s.length()) return true;
        return false;
    }
}