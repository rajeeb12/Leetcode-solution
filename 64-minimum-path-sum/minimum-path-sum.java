class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n + 1][m + 1];
        dp[0][0] = grid[0][0];
        for(int j = 1; j < m ; j++){
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for(int i = 1; i < n; i++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for(int row = 1; row < n; row++){
            for(int col = 1; col < m; col++){
                int up = grid[row][col] + dp[row - 1][col];
                int left = grid[row][col] + dp[row][col - 1];

                dp[row][col] = Math.min(up, left);
            }
        }

        return dp[n - 1][m - 1];
    }
}