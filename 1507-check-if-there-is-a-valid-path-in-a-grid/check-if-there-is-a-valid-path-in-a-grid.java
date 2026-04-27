class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[7][][];
        dp[1] = new int[][]{{0,-1},{0, 1}};
        dp[2] = new int[][]{{-1,0},{1, 0}};
        dp[3] = new int[][]{{0,-1},{1, 0}};
        dp[4] = new int[][]{{0, 1},{1, 0}};
        dp[5] = new int[][]{{0,-1},{-1,0}};
        dp[6] = new int[][]{{0, 1},{-1,0}};

        boolean visited[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] i = q.poll();
            
            if(i[0] == n - 1 && i[1] == m - 1) return true;

            int value = grid[i[0]][i[1]];
            for(int cord[]: dp[value]){
                int ni = cord[0] + i[0];
                int nj = cord[1] + i[1];

                if(ni < 0 || nj < 0 || ni >= n || nj >= m || visited[ni][nj]) continue;

                for(int cord2[]: dp[grid[ni][nj]]){
                    if(cord2[0] + ni == i[0] && cord2[1] + nj == i[1]){
                        q.add(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }
        }
        return false;
    }
}
// 1 - connect left & right
// 2 - upper and lower
// 3 - left & lower
// 4 - right & lower
// 5 - left & upper
// 6 - right & upper

