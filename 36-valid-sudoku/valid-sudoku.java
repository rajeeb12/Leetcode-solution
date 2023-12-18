class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean flag = true;
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < n ; j++)
            {
                if(Character.isDigit(board[i][j]))
                {
                    if(!checkValid(board,i,j))
                    {
                        System.out.print(1);
                        return false;
                    }
                }
            }
        }
        if(!validBox(board))
        {
            return false;
        }
        return true;
    }
    public boolean validBox(char board[][])
    {
        for(int sr = 0 ; sr < 7; sr += 3)
        {
            int er = sr + 2;
            for(int sc = 0 ; sc < 7; sc += 3)
            {
                int ec = sc + 2;
                HashSet<Integer> set = new HashSet<>();
                for(int i = sr; i <= er; i++)
                {
                    for(int j = sc ; j <= ec ; j++)
                    {
                        if(board[i][j] == '.') continue;
                        int value = board[i][j] - '0';

                        if(set.contains(value)) return false;

                        set.add(value);
                    }
                }
            }
        }
        return true;
    }
    public boolean checkValid(char[][] board,int row, int col)
    {
        HashSet<Integer> set = new HashSet<>();
        //col
        for(int i = 0 ; i < 9; i++)
        {
            if(board[row][i] =='.') continue;
            int value = board[row][i] -'0';
            if(set.contains(value)) return false;

            set.add(value);
        }
        HashSet<Integer> set1 = new HashSet<>();
        //row
        for(int i = 0 ; i < 9; i++)
        {
            if(board[i][col] =='.') continue;
            int value = board[i][col] -'0';
            if(set1.contains(value)) return false;

            set1.add(value);
        }
        return true;
    }
}