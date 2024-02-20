class Solution {
    public void rotate(int[][] matrix) {
        int n= matrix.length;
        int m= matrix[0].length;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0 ; j < i; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i[]: matrix)
        {
            int s = 0 , e = m - 1;
            while(s < e)
            {
                int temp = i[s];
                i[s] = i[e];
                i[e] = temp;
                s++;
                e--;
            }  
        }
    }
}