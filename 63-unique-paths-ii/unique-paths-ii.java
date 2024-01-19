class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        dp = new int[n + 1][m + 1];
        for(int i[]: dp) Arrays.fill(i, -1);

        return solve(n - 1, m - 1, obstacleGrid);
    }
    public int solve(int row, int col, int grid[][])
    {
        if(row >= 0 && col >= 0 && grid[row][col] == 1) return 0;
        if(row < 0 || col < 0) return 0;
        if(row == 0 && col == 0) return 1;
        
        if(dp[row][col] != -1) return dp[row][col];
        

        int up= solve(row - 1, col, grid);
        int left= solve(row, col - 1, grid);

        return dp[row][col] = up + left;
    }
}