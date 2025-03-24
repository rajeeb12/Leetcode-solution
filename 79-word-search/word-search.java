class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(solve(i, j, board, word, 1)) return true;
                }
            }
        }
        return false;
    }
    public boolean solve(int row,int col,char[][] board,String word,int index){

        if(index == word.length()) return true;

        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};
        int m = board.length;
        int n = board[0].length;

        char original = board[row][col];
        board[row][col] = '#';

        for(int dir = 0; dir < 4; dir++){
            int nextRow = row + di[dir];
            int nextCol = col + dj[dir];

            if(nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n && board[nextRow][nextCol] == word.charAt(index) && solve(nextRow, nextCol, board, word, index + 1)){
                return true;
            }
        }

        board[row][col] = original;
        return false;
    }
}