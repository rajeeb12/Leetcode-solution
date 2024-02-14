class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m]; 
        
        for(int j = 0 ; j < m ; j++)
        {
            dfs(0, j, pacific, heights);
            dfs(n-1, j, atlantic, heights);
        }

        for(int i = 0; i < n; i++)
        {
            dfs(i, 0, pacific, heights);
            dfs(i, m-1, atlantic, heights);
        }
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    public void dfs(int i,int j,int[][] visited,int[][] heights)
    {
        visited[i][j] = 1;
        int di[]= {1,-1,0,0};
        int dj[]= {0,0,1,-1};

        for(int k = 0; k < 4; k++)
        {
            int row = i + di[k];
            int col = j + dj[k];
            if(row >= 0 && col >= 0 && row < heights.length && col < heights[0].length && visited[row][col]== 0 && (heights[i][j] <= heights[row][col]))
            {
                dfs(row, col, visited, heights);
            }
        }
    }
}