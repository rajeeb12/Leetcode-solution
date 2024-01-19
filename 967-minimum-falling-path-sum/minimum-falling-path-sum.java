class Solution {
    int dp[][];
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp= new int[n + 1][n + 1];
        
        for(int i = 0 ; i < n; i++)
        {
            dp[0][i] = matrix[0][i];
        }

        int min = (int)1e9;
        // for(int col = 0 ; col < n; col++)
        // {
        //     min = Math.min(min, solve(n - 1, col, matrix, n));
        // }

        for(int row = 1 ; row < n; row++)
        {
            for(int col = 0; col < n; col++)
            {
                int left =(int)1e9;
                int right = (int)1e9;
                if(col > 0 ) left = matrix[row][col] + dp[row - 1][col - 1];
                if(col + 1 < n) right = matrix[row][col] + dp[row -1][col + 1];
                int down = matrix[row][col] + dp[row - 1][col];

                dp[row][col] = Math.min(left, Math.min(right, down));
            }
        }
        for(int i = 0 ; i< n; i++)
        {
            min = Math.min(dp[n-1][i], min);
        }
        return min;
    }
    public int solve(int row,int col,int[][] matrix, int n)
    {
        if(col < 0 || col >= n) return (int)1e9;
        if(row == 0)
        {
            return matrix[0][col];  
        }

        if(dp[row][col] != -1) return dp[row][col];

        int left = matrix[row][col] + solve(row - 1, col - 1, matrix, n);
        int right = matrix[row][col] + solve(row - 1, col + 1, matrix, n);
        int down = matrix[row][col] + solve(row - 1, col , matrix, n);

        return dp[row][col] = Math.min(left, Math.min(right, down));
    }
}