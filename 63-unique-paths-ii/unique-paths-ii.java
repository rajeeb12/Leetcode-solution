class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n + 1][m + 1];
        for(int i[]: dp) Arrays.fill(i, -1);
        return solve(0,0,obstacleGrid,n,m,dp);
    }
    public int solve(int i,int j,int arr[][],int n,int m,int dp[][]){
        if(i == n - 1 && j == m - 1 && arr[i][j] == 0) return 1;

        if(i == n || j == m || arr[i][j] == 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int down = 0, right = 0;

        down += solve(i, j + 1, arr, n, m, dp);
        right += solve(i + 1, j, arr, n, m,dp);

        return dp[i][j] =  down + right;
    }
}