class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length; // row
        int n = grid[0].length; // col
        int visited[][] = new int[m][n];

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == '1' && visited[row][col] == 0){
                    count++;
                    dfs(row, col, grid, visited); 
                }
            }
        }
        return count;
    }
    public void dfs(int row,int col,char[][] grid,int[][] visited){
        visited[row][col] = 1;

        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};

        for(int dir = 0; dir < 4; dir++){
            int nextRow = row + di[dir];
            int nextCol = col + dj[dir];
            if(nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length && grid[nextRow][nextCol] == '1' && visited[nextRow][nextCol] == 0){
                dfs(nextRow, nextCol, grid, visited);
            }
        }
    }
}