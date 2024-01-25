class Solution {
    int dp[][];
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        dp = new int[n + 1][m + 1];
        for(int i[]: dp) Arrays.fill(i, - 1);
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                ans = Math.max(ans, dfs(matrix,i,j,n,m));
            }
        }
        return ans + 1;
    }
    public int dfs(int matrix[][], int i,int j, int n,int m)
    {
        int di[]={1,-1,0,0};
        int dj[]={0,0,1,-1};

        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = 0;
        for(int k = 0 ; k < 4 ; k++)
        {
            int nextRow = i + di[k];
            int nextCol = j + dj[k];
            if(nextRow >=0 && nextCol >= 0 && nextRow < n && nextCol < m && matrix[nextRow][nextCol] > matrix[i][j])
            {
                ans = Math.max(ans, 1 + dfs(matrix,nextRow,nextCol , n , m));
            }  
        }
        return dp[i][j] = ans;
    }
}