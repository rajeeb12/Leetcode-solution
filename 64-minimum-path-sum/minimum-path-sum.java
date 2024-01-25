class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n + 1][m + 1];
        for(int i[] : dp) Arrays.fill(i , - 1);

        return solve(grid, n -1 , m -1);
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