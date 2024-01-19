class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        for(int i[]: dp) Arrays.fill(i, -1);

        return solve(m - 1, n - 1);
    }
    public int solve(int row, int col)
    {
        if(row < 0 || col < 0) return 0;
        if(row == 0 && col == 0) return 1;

        if(dp[row][col] != -1) return dp[row][col];
        int sum = 0;

        sum += solve(row - 1, col);
        sum += solve(row, col - 1);

        return dp[row][col] = sum;
    }
}