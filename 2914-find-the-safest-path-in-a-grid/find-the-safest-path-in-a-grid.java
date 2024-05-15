class Pair{
    int row;
    int col;
    int dist;
    public Pair(int _r,int _c,int _d)
    {
        this.row = _r;
        this.col = _c;
        this.dist = _d;
    }
}
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int arr[][] = new int[n][n];
        for(int it[]: arr) Arrays.fill(it, Integer.MAX_VALUE);
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.dist - b.dist);

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid.get(i).get(j) == 1)
                {
                    arr[i][j] = -1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        bfs(q,arr);
        int low = 1 , high = 400;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(dfs(mid, arr,new int[n][n],0,0)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        } 
        return high;
    }
    public boolean dfs(int dist,int[][] arr,int[][] visited,int row,int col)
    {
        int n = arr.length;
        if(row < 0 || col < 0 || row >= n || col >= n || arr[row][col] < dist || visited[row][col] == 1) return false;
        
        if(row == n - 1 && col == n - 1) return true;
        visited[row][col] = 1;

        boolean left = dfs(dist, arr, visited,row , col - 1);
        boolean right = dfs(dist, arr, visited,row , col + 1);
        boolean up = dfs(dist, arr, visited,row - 1, col);
        boolean down = dfs(dist, arr, visited,row + 1, col);

        return (left || right || up || down);
    }
    
    public void bfs(PriorityQueue<Pair> q, int[][] arr)
    {
        int n = arr.length;
        
        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair p = q.poll();
                int row  = p.row;
                int col = p.col;
                int dist = p.dist;
                for(int k = 0; k < 4; k++)
                {
                    int nrow = row + di[k];
                    int ncol = col + dj[k];
                    
                    if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && arr[nrow][ncol] != -1){
                        if(arr[nrow][ncol] > dist + 1)
                        {
                            arr[nrow][ncol] = dist + 1;
                            q.add(new Pair(nrow, ncol, arr[nrow][ncol]));
                        }
                    }
                }
            }
        }
    }
}