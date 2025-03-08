class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    count++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,char grid[][],int visited[][]){
        visited[i][j] = 1;
        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};

        for(int k = 0; k < 4; k++){
            int ni = i + di[k];
            int nj = j + dj[k];
            if(ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && visited[ni][nj] == 0 && grid[ni][nj] == '1'){
                dfs(ni, nj, grid, visited);
            }
        }
    }
}