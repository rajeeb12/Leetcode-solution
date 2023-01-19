class Node implements Comparable<Node>{
   int node;
   int dist;
   public Node(int node,int dist)
   {
       this.node= node;
       this.dist= dist;
   }
   public int compareTo(Node obj)
   {
       return this.dist - obj.dist;
   }
}
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        
        PriorityQueue<Node> pq= new PriorityQueue<Node>();
        
        int[] dist= new int[V];
        Arrays.fill(dist,(int)Math.pow(10,9));
        dist[S]=0;
        pq.add(new Node(S,0));
        
        while(pq.size() != 0)
        {
            Node p = pq.poll();
            int node= p.node;
            int distance= p.dist;
            
            for(int i=0; i<adj.get(node).size(); i++)
            {
                int adjNode= adj.get(node).get(i).get(0);
                int adjDist= adj.get(node).get(i).get(1);
                
                if(adjDist + distance < dist[adjNode])
                {
                    dist[adjNode]= adjDist + distance;
                    pq.add(new Node(adjNode,dist[adjNode]));
                }
            }
        }
        return dist;
    }
}
