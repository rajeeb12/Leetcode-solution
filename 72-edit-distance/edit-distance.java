class Solution {
    int dp[][];
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new int[n + 1][m + 1];
        int prev[] = new int[m + 1];

        // for(int i = 0 ; i <= n; i++)
        // {
        //     dp[i][0] = i;
        // }
        // for(int j = 0; j <= m; j++)
        // {
        //     dp[0][j] = j;
        // }
        for(int j = 0 ; j <= m; j++)
        {
            prev[j] = j; 
        }
        for(int i = 1; i <=n; i++)
        {
            int cur[] = new int[m + 1];
            cur[0] = i;
            for(int j = 1; j <= m; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    cur[j]  = prev[j -1];
                }
                else{
                    cur[j] = (Math.min(1 + cur[j - 1] , Math.min( 1 + prev[j - 1], 1 + prev[j])));
                }
            }
            prev = cur;
        }
        return prev[m] ;
        //return solve(word1, word2, n-1, m-1);
    }
    public int solve(String s1, String s2, int i,int j)
    {
        if(i < 0)
        {
            return j + 1;
        }
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
        {
            return 0 + solve(s1, s2, i - 1, j - 1);
        }
        return dp[i][j] = ( Math.min(1 + solve(s1, s2, i, j - 1) , Math.min( 1 + solve(s1, s2, i - 1, j - 1), 1 + solve(s1, s2, i - 1, j))));
    }
}