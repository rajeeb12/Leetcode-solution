class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public static boolean solve(char[][] board)
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j]=='.')
                {
                    for(char k='1'; k<='9'; k++)
                    {
                        if(valid(i,j,k,board))
                        {
                            board[i][j]=k;
                            if(solve(board))
                                return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean valid(int row,int col,char num,char[][] board)
    {
        for(int i=0; i<board.length; i++)
        {
            if(board[i][col]==num)
                return false;
            if(board[row][i]==num)
                return false;
            
            if(board[3 * (row/3) + i / 3][3 * (col / 3) + i % 3]==num)
                return false;
        }
        return true;
    }
}