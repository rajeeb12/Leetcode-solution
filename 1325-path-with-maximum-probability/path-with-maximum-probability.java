class Pair{
    int node;
    double wt;
    public Pair(int _n,double _wt){
        this.node = _n;
        this.wt = _wt;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succProb[i];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.wt, a.wt));
        double ans[] = new double[n];
        pq.add(new Pair(start_node, 1));
        ans[start_node] = 1;
        
        while(!pq.isEmpty()){
            int size = pq.size();

            for(int i = 0; i < size; i++){
                Pair p = pq.poll();
                int node = p.node;
                double wt = p.wt;
                if(node == end_node)
                {
                    return wt;
                }

                for(Pair pp: adj.get(node))
                {
                    int adjnode = pp.node;
                    double adjwt = pp.wt;
                    if(ans[adjnode] < wt * adjwt)
                    {
                        ans[adjnode] = wt * adjwt;
                        pq.add(new Pair(adjnode, ans[adjnode]));
                    }
                }
            }
        }
        return 0;
    }
    
}