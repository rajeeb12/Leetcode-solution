class Solution {
    public static void solution(int col,char[][] board, List<List<String>> res)
    {
        if(col == board.length)
        {
            res.add(construct(board));
            return;
        }
        
        for(int row=0; row<board.length; row++)
        {
            if(validate(row,col,board))
            {
                board[row][col]='Q';
                solution(col+1,board,res);
                board[row][col]='.';
            }
        }
    }
    public static boolean validate(int row,int col, char[][] board)
    {
        int dupRow= row;
        int dupCol= col;
        //first upper left check
        while(row>=0 && col >=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            row--;
            col--;
        }
        row= dupRow;
        col= dupCol;
        //second left check
        while(col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            col--;
        }
        //third bottm left check
        col=dupCol;
        while(row < board.length && col >=0)
        {
            if(board[row][col]== 'Q')
            {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    public static List<String> construct(char[][] board)
    {
        List<String> ds= new ArrayList<>();
        for(int i=0; i<board.length; i++)
        {
            String s= new String(board[i]);
            ds.add(s);
        }
        return ds;
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board= new char[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                board[i][j]='.';
            }
        }
        List<List<String>> res= new ArrayList<>();
        solution(0,board,res);
        return res;
    }
    
}
// optimised using hasing

class Solution {
    public static void solution(int col,char[][] board,List<List<String>> res,int[] lowerDia,int[] leftRow,int[] upperDia,int n)
    {
        if(col == n)
        {
            res.add(construct(board));
            return;
        }
        for(int row= 0; row<n; row++)
        {
            if(leftRow[row]==0 && lowerDia[row+col]==0 && upperDia[(n-1) + col-row]==0)
            {
                leftRow[row]=1;
                lowerDia[row+col]=1;
                upperDia[(n-1)+(col-row)]=1;
                board[row][col]='Q';
                solution(col+1,board,res,lowerDia,leftRow,upperDia,n);
                leftRow[row]=0;
                lowerDia[row+col]=0;
                upperDia[(n-1)+(col-row)]=0;
                board[row][col]='.';
            }
        }
    }
    
    public static List<String> construct(char[][] board)
    {
        List<String> ds= new ArrayList<>();
        for(int i=0; i<board.length; i++)
        {
            String s= new String(board[i]);
            ds.add(s);
        }
        return ds;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res= new ArrayList<>();
        char[][] board= new char[n][n];  
        int[] lowerDia= new int[2*n-1];
        int[] leftRow= new int[n];
        int[] upperDia= new int[2*n-1];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                board[i][j]='.';
            }
        }
        solution(0,board,res,lowerDia,leftRow,upperDia,n);
        return res;
    }
}
