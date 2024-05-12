class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
    
        int dp[][] = new int[n][m];
        for(int i[]: dp) Arrays.fill(i, -1);
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                max = Math.max(max, solve(i,j,grid,dp,n,m));
                if(i + 1 < n) max1 = Math.max(max1, grid.get(i + 1).get(j) - grid.get(i).get(j));
                if(j + 1 < m) max1 = Math.max(max1, grid.get(i).get(j + 1) - grid.get(i).get(j));
            }
        }
        if(max == 0) return max1;
        return max;
    }
    public int solve(int i,int j,List<List<Integer>> grid,int[][] dp,int n,int m)
    {
        if(i >= n || j >= m) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;
        if(i + 1 < n) right = grid.get(i + 1).get(j) - grid.get(i).get(j) + solve(i + 1,j,grid,dp,n,m);
        if(j + 1 < m) bottom = grid.get(i).get(j + 1) - grid.get(i).get(j) + solve(i,j + 1,grid,dp,n,m);
         
        dp[i][j] = Math.max(0, Math.max(right, bottom));

        return dp[i][j];
    }
    
}