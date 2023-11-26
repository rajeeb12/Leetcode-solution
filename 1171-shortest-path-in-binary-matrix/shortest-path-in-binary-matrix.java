class Tuple{
    int wt;
    int row;
    int col;
    public Tuple(int _wt,int _r,int _c)
    {
        this.wt = _wt;
        this.row = _r;
        this.col = _c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n == 0 || grid[0][0] == 1) return -1;
        
        int distance[][]= new int[n][n];

        for(int row[]: distance)
        {
            Arrays.fill(row, (int)1e9);
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.add(new Tuple(0,0,0));
        distance[0][0] = 0;

        while(!pq.isEmpty())
        {
            Tuple t = pq.poll();
            int wt = t.wt;
            int row = t.row;
            int col = t.col;

            for(int di = -1; di <= 1; di++)
            {
                for(int dj = -1; dj <= 1 ; dj++)
                {
                    int nextRow = row + di;
                    int nextCol = col + dj;

                    if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n && grid[nextRow][nextCol] == 0)
                    {
                        if(wt + 1 < distance[nextRow][nextCol])
                        {
                            distance[nextRow][nextCol] = wt + 1;
                            pq.add(new Tuple(distance[nextRow][nextCol], nextRow, nextCol));
                        }
                    }
                }
            }
        }
        return (distance[n-1][n-1] == (int)1e9 ? -1 : distance[n-1][n-1] + 1);
    }
}