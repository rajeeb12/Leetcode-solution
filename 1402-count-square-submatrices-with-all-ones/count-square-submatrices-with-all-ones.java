class Solution {
    int dp[][];
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        dp = new int[n + 1][m + 1];

        for(int i[]: dp) Arrays.fill(i, -1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1){
                    ans += solve(i, j, matrix, n, m);
                }
            }
        }
        return ans;
    }
    public int solve(int i,int j,int matrix[][],int n,int m){
        if(i >= n || j >= m || matrix[i][j] == 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 1 + Math.min(solve(i , j + 1, matrix,n , m) , Math.min( solve(i + 1, j + 1, matrix, n, m), solve(i + 1, j, matrix, n, m)));

        return dp[i][j] = ans;
    }
}