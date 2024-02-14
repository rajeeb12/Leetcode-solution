class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length; 
        int[][] visited = new int[n][m];
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0 ; j < m; j++)
            {
                if(grid[i][j] == 1 && visited[i][j] == 0)
                {
                    int area = dfs(i,j,visited,grid,n,m);
                    maxArea = Math.max(maxArea, area);
                }
            }
        } 
        return maxArea;
    }
    public int dfs(int i,int j,int visited[][],int grid[][],int n,int m)
    {
        visited[i][j] = 1;
        int di[] = {1, - 1, 0, 0};
        int dj[] = {0 ,0 , 1, -1};
        
        int area = 1;
        for(int k = 0 ; k < 4; k++)
        {
            int row = i + di[k];
            int col = j + dj[k];
            if(row >= 0 && col >= 0 && row < n && col < m && grid[row][col] == 1 && visited[row][col] == 0)
            {
                area += dfs(row, col, visited, grid, n, m);
            }
        }

        return area; 
    }
}