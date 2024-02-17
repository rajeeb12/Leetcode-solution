class Tuple{
    int wt;
    int i;
    int j;
    public Tuple(int _wt,int _i,int _j)
    {
        this.wt = _wt;
        this.i = _i;
        this.j = _j;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int visited[][] = new int[n][n];
        PriorityQueue<Tuple> pq= new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.add(new Tuple(grid[0][0],0,0));
        visited[0][0] = 1;

        int di[] ={1,-1,0,0};
        int dj[] ={0,0,1,-1};
        while(!pq.isEmpty())
        {
            int size = pq.size();

            for(int it = 0; it < size; it++)
            {
                Tuple temp = pq.poll();
                int wt = temp.wt;
                int i = temp.i;
                int j = temp.j;
                if(i == n - 1 && j == n - 1)
                {
                    return wt;
                }

                for(int k = 0 ; k < 4; k++)
                {
                    int row = i + di[k];
                    int col = j + dj[k];
                    if(row >= 0 && col >=0 && row < n && col < n && visited[row][col] == 0)
                    {
                        visited[row][col] = 1;
                        pq.add(new Tuple(Math.max(grid[row][col], wt) , row, col));
                    }
                }
            }
        }
        return -1;
    }
}