class Pair{
    int row;
    int col;
    int index;
    public Pair(int _row,int _col,int _index){
        this.row = _row;
        this.col = _col;
        this.index = _index;
    }
}
class Solution {
    int di[] = {-1,1,0,0};
    int dj[] = {0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return false;

        int n = board.length;
        int m = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        int visited[][]= new int[n][m]; 

        char firstCh = word.charAt(0);
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m; j++)
            {
                if(board[i][j] == firstCh){
                    if(dfs(i,j,board,1,word,n,m,visited))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int row,int col,char[][] board,int index,String word,int n,int m,int[][] visited){
        if(index == word.length()) return true;
        visited[row][col] = 1;

        for(int i = 0 ; i < 4 ; i++)
        {
            int nextRow = row + di[i];
            int nextCol = col + dj[i];
            if(check(nextRow,nextCol,n,m))
            {
                if(visited[nextRow][nextCol] == 0 && word.charAt(index) == board[nextRow][nextCol])
                {
                  if(dfs(nextRow,nextCol,board,index + 1,word,n,m,visited))
                  {
                    return true;
                  }  
                }
            }
        }
        visited[row][col] = 0;
        return false;
    }
    public boolean check(int r,int c,int n,int m){
        if(r >= 0 && c >= 0 && r < n && c < m){
            return true;
        }
        return false;
    }
}