class Solution {
    int dp[][][][];
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new int[n + 1][n + 1][n + 1][n + 1];

        for(int i[][][]: dp){
            for(int j[][]: i){
                for(int k[] : j)
                {
                    Arrays.fill(k, - 1);
                }
            }
        }
        int ans = solve(0,0,0,0,grid);
        return (ans < 0 ? 0 : ans);
    }
    public int solve(int r1,int c1,int r2,int c2,int[][] grid)
    {
        int n = grid.length;
        if(r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;
        
        if(r1 == n - 1 && c1 == n - 1) return grid[r1][c1];
        if(r2 == n - 1 && c2 == n - 1) return grid[r2][c2];

        if(dp[r1][c1][r2][c2] != -1) return dp[r1][c1][r2][c2];
        
        int cherry = 0;
        if(r1 == r2 && c1 == c2)
        {
            cherry = grid[r1][c1];
        }else{
            cherry = grid[r1][c1] + grid[r2][c2];
        }

        int f1 = solve(r1 , c1 + 1 , r2 , c2 + 1 , grid);
        int f2 = solve(r1 + 1 , c1 , r2 , c2 + 1 , grid);
        int f3 = solve(r1 + 1 , c1 , r2 + 1 , c2 , grid);
        int f4 = solve(r1 , c1 + 1 , r2 + 1 , c2 , grid);

        cherry += Math.max(f1, Math.max(f2,Math.max(f3, f4)));

        return dp[r1][c1][r2][c2] =  cherry;
        
    }
}