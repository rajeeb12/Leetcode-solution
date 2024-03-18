class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                int value = mat[i][j];
                int count = 0;
                for(int k = 0; k < 4; k++)
                {
                    int row = i + di[k];
                    int col = j + dj[k];
                    if(row >= 0 && col >= 0 && row < n && col < m && value > mat[row][col])
                    {
                        count++;
                    }else if(row < 0 || row >= n || col < 0 || col >= m)
                    {
                        count++;
                    }
                }
                if(count == 4)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}