class Solution {
    int dp[];
    public int minDays(int[][] grid) {
        List<int[]> arr = new ArrayList<>();
        int sum = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    arr.add(new int[]{i,j});
                    sum += 1;
                }
            }
        }    

        int visited[][] = new int[n][m];
        int count = 0;
        for(int k = 0; k < n; k++){
            for(int l = 0; l < m; l++){
                if(grid[k][l] == 1 && visited[k][l] == 0){
                    dfs(k,l,grid,visited,n,m);
                    count++;
                }
            }
        }
        if(count > 1 || count == 0) return 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) continue;

                grid[i][j] = 0;
                int visited2[][] = new int[n][m];
                int count2 = 0;
                for(int k = 0; k < n; k++){
                    for(int l = 0; l < m; l++){
                        if(grid[k][l] == 1 && visited2[k][l] == 0){
                            dfs(k,l,grid,visited2,n,m);
                            count2++;
                        }
                    }
                }
                if(count2 > 1 || count2 == 0){
                    return 1;
                }
                grid[i][j] = 1;
            }
        }
        return 2;
    }
    public void dfs(int i,int j,int grid[][],int[][] visited,int n,int m){
        visited[i][j] = 1;
        int di[]= {1,-1,0,0};
        int dj[]={0,0,1,-1};
        for(int k = 0; k < 4; k++)
        {
            int ni = i + di[k];
            int nj = j + dj[k];
            if(ni >= 0 && ni < n && nj >=0 && nj < m && visited[ni][nj] == 0 && grid[ni][nj] == 1){
                dfs(ni, nj, grid,visited,n,m);
            }
        }
    }
}