class Solution {
    public int minimumOperations(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[10][m];

        for(int col = 0; col < m; col++)
        {
            for(int val = 0; val <= 9; val++){
                int count = 0;
                for(int r = 0;  r < n; r++)
                {
                    if(grid[r][col] == val)
                    {
                        count++;
                    }
                }
                if(col == 0)
                {
                    dp[val][col] = n - count;
                }else{
                    int min = (int)1e9;
                    for(int i = 0; i <= 9; i++){
                        if(i == val) continue;
                        min = Math.min(min, dp[i][col - 1]);
                    }
                    dp[val][col] = (n - count) + min;
                }
            }
        }
        int ans = (int)1e9;
        for(int i = 0; i <= 9; i++)
        {
            ans = Math.min(ans, dp[i][m - 1]);
        }
        return ans;
    }
}