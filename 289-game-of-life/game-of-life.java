class Solution {
    int die = 2;
    int live = 3;
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
                            if(board[nextRow][nextCol] == 1 || board[nextRow][nextCol] == die)
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
                        board[row][col] = live;
                    }
                }
                else if(board[row][col] == 1) 
                {
                    count--;
                    if(count < 2)
                    {
                        board[row][col] = die;
                        continue;
                    }
                    if(count > 3)
                    {
                        board[row][col] = die;
                        continue;
                    }
                    board[row][col] = 1;
                }
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
          for(int j = 0 ; j < m ; j++)
          {
            if(board[i][j] == 2) board[i][j] = 0;
            if(board[i][j] == 3) board[i][j] = 1;
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