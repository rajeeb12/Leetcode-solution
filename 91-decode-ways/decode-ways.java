class Solution {
    int dp[];
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0) return 0;

        dp = new int[s.length()+1];
        if(s.charAt(0)=='0') return 0;

        dp[n] = 1;

        for(int index = n-1; index >= 0; index--)
        {
            if(s.charAt(index) == '0') continue;
            int oneLength = dp[index + 1];
            int twoLength = 0;

            if(index < s.length()-1 && Integer.parseInt(s.substring(index, index + 2)) <= 26)
            {
                twoLength = dp[index + 2];
            }
            dp[index] = oneLength+twoLength;
        }
        return dp[0];
    }
    public int solve(int index,String s)
    {
        if(index == s.length())
        {
            return 1;
        }
        if(s.charAt(index) == '0')
        {
            return 0;
        }
        if(dp[index] != -1) return dp[index];
        int oneLength = solve(index + 1,s);
        int twoLength = 0;

        if(index < s.length()-1 && Integer.parseInt(s.substring(index, index + 2)) <= 26)
        {
            twoLength = solve(index + 2,s);
        }
        return dp[index] = oneLength+twoLength;
        
    }
}