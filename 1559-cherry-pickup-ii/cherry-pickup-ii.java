class Solution {
    int dp[][][][];
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n + 1][m + 1][n + 1][m + 1];

        for(int i[][][]: dp)
        {
            for(int j[][]: i)
            {
                for(int k[]: j)
                {
                    Arrays.fill(k, -1);
                }
            }
        }

        return solve(0,0,0,m - 1, grid,n,m);
    }
    public int solve(int r1,int c1,int r2,int c2,int[][] grid,int n,int m)
    {
        int di[] ={1,1,1};
        int dj[] ={-1,0,1};

        int cherry = 0;
        if(r1 == r2 && c1 == c2)
        {
            cherry += grid[r1][c1];
        }else{
            cherry += grid[r1][c1] + grid[r2][c2];
        }
        if(dp[r1][c1][r2][c2] != -1) return dp[r1][c1][r2][c2];
        int ans = 0;
        for(int i = 0; i < 3; i++)
        {
            int nr1 = r1 + di[i];
            int nc1 = c1 + dj[i];
            for(int j = 0; j < 3; j++)
            {
                int nr2 = r2 + di[j];
                int nc2 = c2 + dj[j];
                if(nr1 >= n || nr2 >= n || nc1 < 0 || nc2 < 0 || nc1 >= m || nc2 >= m) continue;
                
                ans = Math.max(ans, solve(nr1,nc1,nr2,nc2, grid,n,m));
            }
        }
        return dp[r1][c1][r2][c2] = cherry + ans;
    }
}