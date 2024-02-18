class Solution {
    int dp[];
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0,s);
    }
    public int solve(int index,String s)
    {
        if(index >= s.length())
        {
            return 1;
        }
        if(dp[index] != -1) return dp[index];

        if(s.charAt(index) == '0')
        {
            return 0;
        }
        int ans1 = solve(index + 1, s);
        int ans2 = 0;

        if(index < s.length()-1 && Integer.parseInt(s.substring(index , index + 2)) <= 26)
        {
            ans2 = solve(index + 2, s);
        }
        return dp[index]= ans1 + ans2;
    }
}