class Pair{
    int node;
    int wt;
    public Pair(int _n,int _wt)
    {
        this.node = _n;
        this.wt = _wt;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x2 - x1) + Math.abs(y2 - y1);

                adj.get(i).add(new Pair(j, dist));
                adj.get(j).add(new Pair(i, dist));
            }
        }
        return prims(adj,n);
    }
    public int prims(ArrayList<ArrayList<Pair>> adj,int n)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);

        pq.add(new Pair(0,0));
        int sum = 0;
        int visited[] = new int[n];
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int node= p.node;
            int dist = p.wt;

            if(visited[node] == 1) continue;

            sum +=dist;
            visited[node] = 1;
            
            for(Pair temp : adj.get(node))
            {
                int adjNode = temp.node;
                int adjDist = temp.wt;
                if(visited[adjNode] == 0)
                {
                    pq.add(new Pair(adjNode, adjDist));
                }
            }
        }
        return sum;
    }
}