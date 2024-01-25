class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //dp = new int[n + 1][m + 1];
        int prev[]= new int[m + 1];

        for(int i = 0 ; i < n ; i++)
        {
            int cur[]= new int[m + 1];
            for(int j = 0 ; j < m ; j++)
            {
                if(i == 0 & j == 0) cur[j] = grid[i][j];
                else{
                    int up= grid[i][j];
                    int left = grid[i][j]; 
                    if(i > 0)
                    {
                        up += prev[j];
                    }else{
                        up += (int)1e9;
                    }

                    if(j > 0){
                        left += cur[j - 1];
                    }else{
                        left += (int)1e9;
                    }
                    cur[j] = Math.min(up, left);
                }
            }
            prev = cur;
        }
        //return solve(grid, n -1 , m -1);
        return prev[m - 1];
    }
    public int solve(int[][] grid,int i, int j)
    {
        if(i < 0 || j < 0) return (int)1e9;
        if(i == 0 && j == 0)
        {
            return grid[0][0];
        }

        if(dp[i][j] != - 1) return dp[i][j];

        int up = grid[i][j] + solve(grid, i - 1, j);
        int left = grid[i][j] + solve(grid, i , j - 1);

        return dp[i][j] = Math.min(left, up);
    }
}