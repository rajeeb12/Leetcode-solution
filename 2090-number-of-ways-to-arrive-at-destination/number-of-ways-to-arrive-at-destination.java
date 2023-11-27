class Pair{
    int node;
    long wt;
    public Pair(int _n,long _w)
    {
        this.node = _n;
        this.wt = _w;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9 + 7;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int road[]: roads)
        {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Pair(v, (long)w)); 
            adj.get(v).add(new Pair(u, (long)w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.wt , b.wt));
        long[] dist = new long[n];
        int ways[]= new int[n];

        Arrays.fill(dist, Long.MAX_VALUE/2);
        pq.add(new Pair(0,0));
        dist[0] = 0;
        ways[0] = 1;

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int node = p.node;
            long wt = p.wt;
        
            for(Pair t : adj.get(node))
            {
                int adjNode = t.node;
                long adjWt = t.wt;
                if(adjWt + wt < dist[adjNode])
                {
                    dist[adjNode] = adjWt + wt;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                    ways[adjNode] = ways[node];
                }
                else if(adjWt + wt == dist[adjNode])
                {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}