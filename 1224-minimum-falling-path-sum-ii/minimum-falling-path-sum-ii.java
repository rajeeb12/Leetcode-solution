class Solution {
    int dp[][];
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n + 1][m + 1];
        for(int i[]: dp){
            Arrays.fill(i, -1);
        }
        return solve(0,-1,grid);
    }
    public int solve(int r,int c,int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;

        if(r == n){
            return 0;
        }
        if(dp[r][c + 1] != -1) return dp[r][c + 1];
        int ans = (int)1e9;
        for(int j = 0; j < m; j++)
        {
            if(c == -1 || c != j){
                ans = Math.min(ans, grid[r][j] + solve(r + 1, j, grid));
            }
        }
        return dp[r][c + 1] = ans;
    }
}