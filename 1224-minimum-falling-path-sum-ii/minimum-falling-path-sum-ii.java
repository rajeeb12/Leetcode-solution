class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; 
        int dp[][]= new int[n + 1][m + 1];
        for(int i = 0; i < m; i++)
        {
            dp[n - 1][i] = grid[n - 1][i];
        }
        for(int r = n - 2; r >= 0; r--)
        {
            for(int c = 0; c < m; c++)
            {
                int ans = (int)1e9;
                for(int j = 0; j < m; j++)
                {
                    if(c != j)
                    {
                        ans = Math.min(ans,dp[r + 1][j]);
                    }
                }
                dp[r][c] = ans + grid[r][c]; 
            }
        }
        int res = (int)1e9;
        for(int i = 0; i < m; i++)
        {
            res = Math.min(res, dp[0][i]);
        }
        return res;
    }
}