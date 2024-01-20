class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int visited[][]= new int[n][m];

        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] == 0)
                {
                    count++;
                    dfs(i,j,grid, visited,n,m);
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,char[][] grid, int[][] visited,int n,int m)
    {
        visited[i][j] =1;

        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};

        for(int k = 0 ; k < 4 ; k++)
        {
            int next_row = i + di[k];
            int next_col = j + dj[k];

            if(validCo(next_row, next_col,n, m) && grid[next_row][next_col]=='1' && visited[next_row][next_col] == 0)
            {
                dfs(next_row, next_col,grid, visited, n, m);
            }
        }
    }
    public boolean validCo(int i,int j,int n,int m)
    {
        if(i >= 0 && j >= 0 && i < n && j < m) return true;
        return false;
    }
}