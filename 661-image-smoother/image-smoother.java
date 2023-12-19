class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int ans[][]= new int[n][m];

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m; j++)
            {
                int count = 0, sum = 0;
                for(int idi = -1; idi <=1; idi++)
                {
                    for(int idj = -1; idj <= 1; idj++)
                    {
                        int newRow = i + idi;
                        int newCol = j + idj;

                        if(newRow >= 0 && newCol >=0 && newRow < n && newCol < m)
                        {
                            sum += img[newRow][newCol];
                            count++;
                        }
                    }
                }
                ans[i][j] =(int)Math.floor(sum / count);
            }
        }
        return ans;
    }
}