
// User function Template for Java
class Pair{
    int node;
    int wt;
    public Pair(int node,int wt)
    {
        this.node= node;
        this.wt= wt;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edge[][]) {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0; i<=n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++)
        {
            int u = edge[i][0];
            int v = edge[i][1];
            int wt= edge[i][2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x,y)-> x.wt - y.wt);
        int[] dist= new int[n+1];
        int[] parent= new int[n+1];
        for(int i=1; i<=n; i++)
        {
            parent[i]=i; 
        }
        
        Arrays.fill(dist,(int)Math.pow(10,9));
        dist[1]=0;
        
        pq.add(new Pair(1,0));
        
        while(pq.size() != 0)
        {
            Pair p = pq.poll();
            int node= p.node;
            int weight= p.wt;
            
            for(Pair q: adj.get(node))
            {
                int adjNode= q.node;
                int wt= q.wt;
                if(weight + wt < dist[adjNode])
                {
                    dist[adjNode]= weight + wt;
                    parent[adjNode] = node;
                    pq.add(new Pair(adjNode, weight + wt));
                }
            }
        }
        List<Integer> path= new ArrayList<>();
        if(dist[n] == (int)Math.pow(10,9))
        {
            path.add(-1);
            return path;
        }
        int node= n;
        while(parent[node]!=node)
        {
            path.add(node);
            node= parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}