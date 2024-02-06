class Solution {
    int dp[][];
    public int longestPalindromeSubseq(String str) {
        StringBuilder s = new StringBuilder(str);
        StringBuilder t = new StringBuilder(str);
        t.reverse();
        int n = s.length();
        //dp = new int[n + 1][n + 1];
        int prev[] = new int[n + 1];
        for(int i = 1; i <=n ; i++)
        {
            int cur[] = new int[n + 1];
            for(int j = 1; j <= n; j++)
            {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                {
                    cur[j] = 1 + prev[j - 1];
                } 
                else{
                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
            }
            prev = cur;
        }
        return prev[n];
        //return dp[n][n];
        //return solve(n - 1, n - 1,str1.toString(), str2.toString());
    }
    public int solve(int i,int j,String s,String t)
    {
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j))
        {
            return dp[i][j] = 1 + solve(i - 1, j - 1, s, t);
        } 
        else{
            return dp[i][j] = Math.max(solve(i - 1, j, s, t), solve(i, j - 1,s,t));
        }
    }
}