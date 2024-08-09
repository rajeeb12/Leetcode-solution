class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        if(n < 3 || m < 3)
        {
            return 0;
        }
        for(int i = 0; i <= n - 3; i++){
            for(int j = 0; j <= m - 3; j++){
                // 3 row;
                int row1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                int row2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
                int row3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                //3 col
                int col1 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                int col2 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
                int col3 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
                // dia
                
                int ldiag = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
                int rdiag = grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2];
                int map[] = new int[10];
                Arrays.fill(map, 1);
                for(int row = i; row < i + 3; row++){
                    for(int col = j; col < j + 3; col++){
                        if(grid[row][col] >= 10) continue;
                        map[grid[row][col]]--;
                    }
                }
                boolean isValid = true;
                for(int num = 1; num < 10; num++){
                    if(map[num] != 0) isValid =false;
                }

                if(isValid && row1 == row2 && row2 == row3 && row3 == col1 && col1 == col2 && col2 == col3 && col3 == ldiag && ldiag == rdiag) count++;
            }
        }
        return count;
    }
}