class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> ans = new ArrayList<>();
        int n = land.length;
        int m = land[0].length;
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(land[i][j] ==1){
                    int[] cord = dfs(land,i,j);
                    ans.add(cord);
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public int[] dfs(int[][] land,int r,int c)
    {
        int n = land.length;
        int m = land[0].length;
        int cord[] = new int[4];
        cord[0] = r;
        cord[1] = c;
        int row = r;
        int col = c;
        while(row < n && land[row][c] == 1) row++;
        while(col < m && land[r][col] == 1) col++;


        cord[2] = row - 1;
        cord[3] = col - 1;
        for(int i = r; i < row; i++)
        {
            for(int j = c; j < col; j++)
            {
                land[i][j] = 0;
            }
        }
        return cord;
    }
}