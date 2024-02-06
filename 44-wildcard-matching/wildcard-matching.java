class Solution {
    boolean dp[][];
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        dp = new boolean[n + 1][m + 1];
        
        dp[0][0] = true;

        for(int j = 1; j <= m ; j++) // pattern
        {
            boolean flag = true; 
            for(int start = 1; start <= j; start++)
            {
                if(p.charAt(start - 1)!= '*')
                {
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(p.charAt(j - 1) == '*')
                {
                    dp[i][j] = (dp[i][j - 1] || dp[i - 1][j]);
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
        //return (solve(n - 1, m - 1, s, p) == 1 ? true : false);
    }
    // public int solve(int i,int j,String s,String p)
    // {
    //     if(i < 0 && j < 0) return 1;
    //     if(j < 0 && i >= 0 ) return 0;
    //     if(i < 0 && j > 0)
    //     {
    //         for(int start = 0; start <= j; start++)
    //         {
    //             if(p.charAt(start)!= '*')
    //             {
    //                 return 0;
    //             }
    //         }
    //         return 1;
    //     } 

    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
    //     {
    //         return dp[i][j] = (solve(i - 1, j - 1, s,p) == 1 ? 1 : 0);
    //     }
    //     else if(p.charAt(j) == '*')
    //     {
    //         return dp[i][j] = ((solve(i , j - 1 , s, p ) == 1 || solve(i - 1 , j, s, p) == 1) ? 1 : 0);
    //     }
    //     return 0;
    // }
}