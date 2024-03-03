class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int row[] = new int[n];
        int col[] = new int[m];
        Arrays.fill(row, -(int)1e9);
        Arrays.fill(col, -(int)1e9);

        for(int i = 0 ; i < n; i++)
        {
            for(int c = 0 ; c < m; c++)
            {
                row[i] = Math.max(row[i], grid[i][c]);       
            }
            for(int j = 0 ; j < m; j++)
            {
                for(int r = 0; r < n; r++)
                {
                    col[j] = Math.max(col[j], grid[r][j]);
                }
            }
        }
        int maxSum = 0;
        for(int i =0 ; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                int increasedHeight = Math.min(row[i] , col[j]);
                maxSum += (increasedHeight - grid[i][j]);
            }
        }
        return maxSum;
    }
}