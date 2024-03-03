class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int sx = -1, sy = -1, zero = 0;  
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 0) zero++;
                if(grid[i][j] == 1)
                {
                    sx = i;
                    sy = j;
                }
            }
        }
        int visited[][]= new int[n][m];
        return solve(sx,sy,grid,zero,visited,n,m);
    }
    public int solve(int i,int j,int[][] grid,int zero,int[][] visited,int n,int m)
    {
        if(grid[i][j] == 2)
        {
            return (zero == -1 ? 1 : 0);
        }
        
        visited[i][j] = 1;
        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};
        int ways = 0;
        zero--;

        for(int k = 0; k < 4; k++)
        {
            int r = di[k] + i;
            int c = dj[k] + j;
            if(r >= 0 && c >= 0 && r < n && c < m && visited[r][c] == 0 && grid[r][c] != -1)
            {
                ways += solve(r,c,grid,zero,visited,n,m);
            }
        }
        visited[i][j] = 0;
        zero++;
        return ways;
    }
}