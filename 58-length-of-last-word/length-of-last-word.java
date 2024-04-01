class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int len = 0;
        for(int i = n - 1; i >=0; i--)
        {
            if(s.charAt(i) != ' ') len++;
            else if(len > 0) break;
        }
        return len;
    }
}