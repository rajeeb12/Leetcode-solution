class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    int visited[][] = new int[m][n];
                    if(check(i,j,1,visited, board, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean check(int row,int col,int index,int visited[][],char[][] board,String word){
        
        if(index >= word.length()) return true;
        
        visited[row][col] = 1;

        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};

        for(int k = 0; k < 4; k++){
            int nextRow = row + di[k];
            int nextCol = col + dj[k];

            if(nextRow >= 0 && nextCol >= 0 && nextRow < board.length && nextCol < board[0].length && board[nextRow][nextCol] == word.charAt(index) && visited[nextRow][nextCol] == 0 && check(nextRow, nextCol, index + 1, visited, board, word)){
                return true;
            }
        }
        
        visited[row][col] = 0;
        
        return false;

    }
}