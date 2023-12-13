class Solution {
    public int numSpecial(int[][] mat) {
        int count =0;
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0 ; j < m; j++)
            {
                if(mat[i][j] == 1)
                {
                    if(check(i,j, mat))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean check(int row,int col,int[][] mat)
    {
        for(int i = 0 ; i < mat[0].length; i++)
        {
            if(i == col) continue;
            if(mat[row][i] == 1)
            {
                return false;
            }
        }
        for(int i = 0 ; i < mat.length; i++)
        {
            if(i == row) continue;
            if(mat[i][col] == 1)
            {
                return false;
            }
        }
        return true;
    }
}