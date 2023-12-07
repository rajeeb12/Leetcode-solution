class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int ans[][] = new int[n][m];
        
        for(int row = 0 ; row < n ; row++)
        {
            for(int col = 0 ; col < m ; col++)
            {
                int count = 0;
                for(int di = -1; di <= 1; di++)
                {
                    for(int dj = -1 ; dj <= 1; dj++)
                    {
                        int nextRow = row + di;
                        int nextCol = col + dj;
                        if(isValid(nextRow, nextCol,n,m))
                        {
                            if(board[nextRow][nextCol] == 1)
                            {
                                count++;
                            }
                        }
                    }
                }
                if(board[row][col] == 0)
                {
                    if(count == 3)
                    {
                        ans[row][col] = 1;
                    }
                }
                else if(board[row][col] == 1) 
                {
                    count--;
                    if(count < 2)
                    {
                        ans[row][col] = 0;
                        continue;
                    }
                    if(count > 3)
                    {
                        ans[row][col] = 0;
                        continue;
                    }
                    ans[row][col] = 1;
                }
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
          for(int j = 0 ; j < m ; j++)
          {
            board[i][j] = ans[i][j];
          }
        }
    }
    public boolean isValid(int row,int col,int n,int m)
    {
        if(row >= 0 && col >= 0 && row < n && col < m)
        {
            return true;
        }
        return false;
    }
}