class Solution {
    int dp[][];
    public int minFallingPathSum(int[][] matrix) {
        int min = (int)1e9;
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n + 1][m + 1];

        for(int col = 0; col < m; col++){
            dp[n - 1][col] = matrix[n - 1][col];
        }

        for(int row = n - 2; row >= 0; row--){
            for(int col =  0; col < m ; col++)
            {
                int left = (int)1e9, right = (int)1e9, middle = (int)1e9;

                if(col - 1 >= 0) left = dp[row + 1][col - 1];
                if(col + 1 < m) right = dp[row + 1][col + 1];
                middle = dp[row + 1][col];
                System.out.println(matrix[row][col] + " "+ left +" " + right+" "+ middle);

                dp[row][col] = matrix[row][col] + Math.min(left, Math.min(right, middle));
            }  
        }
        for(int i = 0; i < m; i++) min = Math.min(min, dp[0][i]);
        
        return min;
    }
    public int solve(int row, int col, int matrix[][]){
        if(col >= matrix.length || col < 0) return (int)1e9;
        if(row >= matrix.length) return 0;
        
        if(dp[row][col] != -1) return dp[row][col];

        int left = matrix[row][col] + solve(row + 1, col - 1, matrix);
        int right = matrix[row][col] + solve(row + 1, col + 1, matrix);
        int middle = matrix[row][col] + solve(row + 1, col, matrix);

        return dp[row][col] = Math.min(left, Math.min(right, middle));
    }
    
}