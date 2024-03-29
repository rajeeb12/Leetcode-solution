class Solution {
    int dp[][];
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        //dp = new int[n + 1][m + 1];
        int prev[] = new int[m + 1];
        
        // for(int i = 0 ; i <= n; i++)
        // {
        //     // dp[i][0] = 1;
        // }
        prev[0] = 1;

        for(int i = 1; i <= n; i++)
        {
            int cur[] = new int[m + 1];
            cur[0]= 1;
            for(int j = 1; j <= m; j++)
            {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                {
                    cur[j]= (prev[j] + prev[j - 1]);
                }
                else{
                    cur[j] = prev[j];
                }
            }
            prev = cur;
        }
        return prev[m];
        ///return dp[n][m];
        //return solve(n - 1,  m - 1,s,t);   
    }
    public int solve(int i,int j,String s,String t)
    {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j))
        {
            return dp[i][j]= (solve(i - 1, j, s, t) + solve(i - 1, j - 1, s, t));
        }
        else{
            return dp[i][j] = solve(i - 1, j , s, t);
        }
    }
}