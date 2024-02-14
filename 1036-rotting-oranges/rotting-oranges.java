class Pair{
    int row;
    int col;
    public Pair(int _r,int _c)
    {
        this.row = _r;
        this.col = _c;
    }
}
class Solution {
    int n;
    int m;
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int visited[][] = new int[n][m];

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new Pair(i,j));
                    visited[i][j] = 1;
                }
            }
        }
        int di[]= {1,-1,0,0};
        int dj[]= {0,0,1,-1};
        int time = 0;
        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                Pair p = q.poll();
                int r = p.row;
                int c = p.col;

                for(int k = 0; k < 4; k++)
                {
                    int row = r + di[k];
                    int col = c + dj[k];
                    if(check(row, col) && grid[row][col] == 1 && visited[row][col] == 0)
                    {
                        grid[row][col] = 2;
                        visited[row][col] = 1;
                        q.add(new Pair(row, col));
                    }
                }
            }
            time++;
        }
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0 ; j < m; j++)
            {
                if(grid[i][j] == 1)
                {
                    return -1;
                }
            }
        }
        return (time == 0 ? 0 : time - 1);
    }
    public boolean check(int i,int j)
    {
        if(i < 0 || j < 0 || i >= n || j >= m) return false;
        return true;
    }
}