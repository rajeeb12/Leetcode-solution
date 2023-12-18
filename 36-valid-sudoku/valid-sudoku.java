class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i= 0 ; i < 9; i++)
        {
            for(int j= 0 ; j < 9 ; j++)
            {
                if(board[i][j] =='.') continue;

                String normal= "(" + board[i][j] + ")";
                String normalWithRow = i+"" + normal;
                String normalWithCol = normal +"" +j;
                int boxRow = i / 3;
                int boxCol = j / 3;
                String normalWithBox= boxRow +""+normal+""+boxCol;
                if(set.contains(normalWithRow) || set.contains(normalWithCol) ||set.contains(normalWithBox))
                {
                    return false;
                }
                set.add(normalWithRow);
                set.add(normalWithCol);
                set.add(normalWithBox);
            }
        }
        return true;
    }
}