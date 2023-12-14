class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; 
        int row[]= new int[n];
        int col[]= new int[m];

        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                int oneRow = row[i];
                int oneCol = col[j];
                int zeroRow = n - row[i];
                int zeroCol = m - col[j];
                grid[i][j] = oneRow + oneCol - zeroRow - zeroCol;
            }
        }
        return grid;
    }
}