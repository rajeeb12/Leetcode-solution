class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length, fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2) q.add(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;
            }
        }

        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};
        int time = 0;
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int temp[] = q.poll();
                int row = temp[0];
                int col = temp[1];
                for(int k = 0; k < 4; k++){
                    int nrow = row + di[k];
                    int ncol = col + dj[k];
                    if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 1){
                        q.add(new int[]{nrow, ncol});
                        grid[nrow][ncol] = 2;
                        fresh--;
                    }
                }
            }
            time++;
           
        }
        if(fresh == 0) return time;
        return -1;
    }
}