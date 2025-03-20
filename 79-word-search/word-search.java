class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(check(i,j,1, board, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean check(int row,int col,int index,char[][] board,String word){
        
        if(index >= word.length()) return true;
        
        char temp = board[row][col];
        board[row][col] = '$';

        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};

        for(int k = 0; k < 4; k++){
            int nextRow = row + di[k];
            int nextCol = col + dj[k];

            if(isValid(nextRow, nextCol, board) && board[nextRow][nextCol] == word.charAt(index) && check(nextRow, nextCol, index + 1, board, word)){
                return true;
            }
        }
        
        board[row][col] = temp;
        
        return false;
    }
    public boolean isValid(int nextRow,int nextCol,char[][] board){
        if(nextRow >= 0 && nextCol >= 0 && nextRow < board.length && nextCol < board[0].length) return true;
        return false;
    }
}