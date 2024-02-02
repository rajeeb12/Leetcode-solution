class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char arr[] = word.toCharArray();

        int visited[][] = new int[n][m];
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if(board[i][j] == arr[0])
                {
                    if(solve(i,j,board,visited,arr, n , m,1))
                    {
                        return true;
                    }
                }
            }
        } 
        return false;
    }
    public boolean solve(int row, int col, char[][] board,int[][] visited,char[] arr, int n,int m,int index)
    {
        if(index == arr.length)
        {
            return true;
        }
        visited[row][col] = 1;

        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};

        for(int i = 0 ; i < 4; i++)
        {
            int next_row = row + di[i];
            int next_col = col + dj[i];
            if(helper(next_row,next_col, n ,m))
            {
                if(board[next_row][next_col] == arr[index] && visited[next_row][next_col] == 0)
                {
                    if(solve(next_row,next_col,board,visited,arr, n , m, index + 1))
                    {
                        return true;
                    }
                }
            }
        } 
        visited[row][col] = 0;
        return false;
    }
    public boolean helper(int next_row,int next_col,int n,int m)
    {
        if(next_row >=0 && next_col >= 0 && next_row < n && next_col < m) return true;
        return false;
    }
}