class Solution {
    int dp[];
    public int numDecodings(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return solve(0, s);
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