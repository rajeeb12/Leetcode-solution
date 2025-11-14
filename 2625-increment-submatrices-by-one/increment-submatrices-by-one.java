class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int ans[][]= new int[n][n];
        
        for(int querie[]: queries)
        {
            int row1= querie[0];
            int col1= querie[1];
            int row2= querie[2];
            int col2= querie[3];
            
            for(int i= row1; i<=row2; i++)
            {
                for(int j= col1; j<=col2; j++)
                {
                    ans[i][j]++;
                }
            }
        }
        return ans;
    }
}