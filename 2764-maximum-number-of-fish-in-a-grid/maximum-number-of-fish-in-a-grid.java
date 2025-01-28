class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 0) continue;
                max = Math.max(max, solve(i,j, grid));
            }
        } 
        return max;
    }
    public int solve(int i,int j,int grid[][]){

        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};

        int max = grid[i][j];
        grid[i][j] = 0;
        for(int k = 0; k < 4; k++){
            int ni = i + di[k];
            int nj = j + dj[k];
            if(ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && grid[ni][nj] > 0){
                max += solve(ni, nj, grid);
            }
        }
        return max;
    }
}