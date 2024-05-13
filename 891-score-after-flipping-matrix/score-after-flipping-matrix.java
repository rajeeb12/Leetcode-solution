class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n; i++)
        {
            if(grid[i][0] == 0)
            {
                toogle(i, grid);
            }
        }
        for(int j = 0; j < m; j++)
        {
            int count0 = 0;
            for(int i = 0; i < n; i++)
            {
                if(grid[i][j] == 0) count0++;
            }
            int count1 = n - count0;
            if(count0 > count1)
            {
                for(int r = 0; r < n; r++)
                {
                    grid[r][j] = 1 - grid[r][j];
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            int num = 0;
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) num |= (1 << m - j - 1);
            }
            //System.out.print(num);
            sum += num;
        }
        return sum;
    }
    public void toogle(int row,int[][] grid)
    {
        for(int i = 0; i < grid.length; i++)
        {
            if(i != row) continue;
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1) grid[i][j] = 0;
                else grid[i][j] = 1;
            }
        }
    }
    
}