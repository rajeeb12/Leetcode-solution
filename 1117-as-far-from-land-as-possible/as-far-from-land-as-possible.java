class Pair{
    int i;
    int j;
    int level;
    public Pair(int _i,int _j,int _l)
    {
        this.i = _i;
        this.j = _j;
        this.level = _l;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        Queue<Pair> q= new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1)
                {
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int di[] ={1,-1,0,0};
        int dj[] ={0,0,1,-1};
        int ans = -1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                Pair p = q.poll();
                int r = p.i;
                int c = p.j;
                int level = p.level;

                if(level != 0) ans = Math.max(level, ans);
                for(int k = 0; k < 4; k++)
                {
                    int ni = r + di[k];
                    int nj = c + dj[k];
                    if(ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 0){
                        grid[ni][nj] = level + 1;
                        q.add(new Pair(ni, nj, level + 1));
                    }
                }
            }
        }
        return ans;
    }
}