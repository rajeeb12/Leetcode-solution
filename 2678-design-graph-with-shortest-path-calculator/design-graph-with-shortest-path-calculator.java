class Pair{
    int v;
    int cost;
    public Pair(int _v, int _cost){
        this.v = _v;
        this.cost = _cost;
    }
}
class Graph {
    ArrayList<ArrayList<Pair>> adj;
    public Graph(int n, int[][] edges) {
        adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            adj.get(u).add(new Pair(v,cost));
        }
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int cost = edge[2];
        adj.get(u).add(new Pair(v,cost));
    }
    
    public int shortestPath(int node1, int node2) {
        return dijsktra(node1, node2);
    }
    public int dijsktra(int start, int end){

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b) -> a.cost - b.cost);

        int distance[]= new int[adj.size()];

        Arrays.fill(distance,(int)1e9);
        
        distance[start] = 0;
        
        pq.add(new Pair(start, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int currentNode = p.v;
            int currentCost = p.cost;
            if(currentCost > distance[currentNode]) continue;

            if(currentNode == end) return currentCost;

            for(Pair temp: adj.get(currentNode)){
                int adjNode = temp.v;
                int cost = temp.cost;

                if(distance[adjNode] > cost + distance[currentNode]){
                    distance[adjNode] = cost + distance[currentNode];
                    pq.add(new Pair(adjNode,distance[adjNode]));
                }
            }
        }
        return (distance[end] == (int)1e9 ? -1 : distance[end]);
    }
    
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */