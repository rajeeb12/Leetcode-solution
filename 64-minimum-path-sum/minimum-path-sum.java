class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n + 1][m + 1];
        for(int i[]: dp) Arrays.fill(i, - 1);

        return solve(n - 1, m - 1, grid);
    }
    public int solve(int row,int col,int grid[][]){
        if(row < 0 || col < 0) return (int)1e9;
        if(row == 0 && col == 0) return grid[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int up = grid[row][col] + solve(row - 1, col, grid);
        int left = grid[row][col] + solve(row, col - 1, grid);

        return dp[row][col] = Math.min(up, left);
    }
}