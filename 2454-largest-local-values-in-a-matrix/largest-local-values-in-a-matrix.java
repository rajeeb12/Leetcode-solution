class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int m = 3;
        int ans[][] = new int[n - 2][n - 2];

        for(int i = 0; i < n - 2; i++)
        {
            for(int j = 0; j < n - 2; j++)
            {
                int max = 0;
                for(int row = i; row < i + m; row++)
                {
                    for(int col = j ; col < j + m; col++)
                    {
                        max = Math.max(max, grid[row][col]);
                    }
                }
                ans[i][j] = max;
            }
        }
        return ans;
    }
}