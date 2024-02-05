class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int len = 0;
        int n = s.length();
        for(int i = 0; i < n ; i++)
        {
            int left = i, right = i;
            while(left >= 0 && right < n && s.charAt(left) ==s.charAt(right))
            {
                int curmax = right - left + 1; 
                if(len < curmax)
                {
                    len = right - left + 1;
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
            
            left = i ; right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) ==s.charAt(right))
            {
                int curmax = right - left + 1; 
                if(len < curmax)
                {
                    len = right - left + 1;
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
            
        }
        return s.substring(start,end + 1);
    }
}