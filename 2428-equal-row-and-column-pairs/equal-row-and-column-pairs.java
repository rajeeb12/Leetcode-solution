class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length; 

        for(int row[]: grid)
        {
            for(int i = 0 ; i < m; i++)
            {
                int count = 0;
                for(int j = 0 ; j < n ; j++)
                {
                    if(row[j] == grid[j][i])
                    {
                        count++;
                    }
                    else{
                        break;
                    }
                }
                if(count == row.length){
                    ans++;
                }
            }
        }
        return ans;
    }
}