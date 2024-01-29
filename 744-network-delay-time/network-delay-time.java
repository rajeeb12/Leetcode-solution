class Pair{
    int v;
    int time;
    public Pair(int _v,int _t)
    {
        this.v = _v;
        this.time = _t;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <=n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int time[]: times)
        {
            int u = time[0];
            int v = time[1];
            int t = time[2];

            adj.get(u).add(new Pair(v, t));
        }
        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int)1e9);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k,0));
        dist[k]=0;

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size; i++)
            {
                Pair p = q.poll();
                int node = p.v;
                int time = p.time;

                for(Pair t: adj.get(node))
                {
                    int adjNode = t.v;
                    int adjTime = t.time;
                    if(adjTime + time < dist[adjNode])
                    {
                        dist[adjNode] = adjTime + time;
                        q.add(new Pair(adjNode, dist[adjNode]));
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++)
        {
            if(dist[i] == (int)1e9) return -1;
            ans =Math.max(ans, dist[i]);
        }
        return ans;
    }
}