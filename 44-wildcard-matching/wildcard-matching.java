class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        // boolean dp[][] = new boolean[n + 1][m + 1];
        boolean prev[]= new boolean[m + 1];
        prev[0] = true;

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
            prev[j] = flag;
        }

        for(int i = 1; i <= n; i++)
        {
            boolean cur[] = new boolean[m + 1];
            for(int j = 1; j <= m; j++)
            {
                cur[0] = isAllstar(p,j);
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                {
                    cur[j] = prev[j - 1];
                }
                else if(p.charAt(j - 1) == '*')
                {
                    cur[j] = (cur[j - 1] || prev[j]);
                }else{
                    cur[j] = false;
                }
            }
            prev = cur;
        }
        return prev[m];
        //return (solve(n - 1, m - 1, s, p) == 1 ? true : false);
    }
    public boolean isAllstar(String s, int j)
    {
        for(int i = 1 ; i <= j ; i++)
        {
            if(s.charAt(i - 1) != '*') return false;
        }
        return true;
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