class Solution {
    int dp[][][];
    public int maxPathScore(int[][] grid, int k) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m + 1][n + 1][k + 1];
        for(int i[][]: dp){
            for(int j[]: i){
                Arrays.fill(j, -1);
            }
        }

        int ans = solve(m - 1, n - 1,grid,visited,k);
        return (ans < 0 ? -1 : ans);
    }
    public int solve(int i,int j,int grid[][],boolean visited[][],int k){
        if(i < 0 || j < 0 || visited[i][j] || k < 0) return -(int)1e9;
        if(i == 0 && j == 0){
            return 0;
        }

        if(dp[i][j][k] != -1) return dp[i][j][k];

        visited[i][j] = true;
        int left = grid[i][j] + solve(i, j - 1, grid, visited, (grid[i][j] == 0 ? k : k - 1));
        int up = grid[i][j] + solve(i - 1, j , grid, visited,  (grid[i][j] == 0 ? k : k - 1));
        visited[i][j] = false;
        return dp[i][j][k] = Math.max(left, up); 
    }
}