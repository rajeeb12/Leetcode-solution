class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();
        if(n < 2) return s;
        int max = 0;
        int start = 0;
        int end = 0;

        for(int i = 0 ; i < n ; i++)
        {
            // odd length
            int left = i, right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {
                int sum = right - left + 1;
                if(max < sum)
                {
                    max = sum;
                    start = left;
                    end = right + 1;
                }
                left--;
                right++;
            }
            //even
            left = i; right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {
                int sum = right - left + 1;
                if(max < sum)
                {
                    max = sum;
                    start = left;
                    end = right + 1;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, end);
    }
}