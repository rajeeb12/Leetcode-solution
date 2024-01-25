class Solution {
    int dp[][];
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n + 1][n + 1];
        
        for(int i = 0 ; i < n ; i++)
        {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for(int i = n - 2 ; i >= 0 ; i--)
        {
            for(int j = i ; j >= 0; j--)
            {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int rightDiag = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j]= Math.min(down , rightDiag);
            }
        }
        //return solve(triangle, 0, 0, n );
        return dp[0][0];
    }
    public int solve(List<List<Integer>> triangle , int i, int j,int n)
    {
        if(i == n - 1)
        {
            return triangle.get(n - 1).get(j);
        }

        if(dp[i][j] != -1) return dp[i][j];

        int down = triangle.get(i).get(j) + solve(triangle, i + 1, j, n);
        int rightDiag = triangle.get(i).get(j) + solve(triangle, i + 1, j + 1, n);
        return dp[i][j]= Math.min(down , rightDiag);
    }
}