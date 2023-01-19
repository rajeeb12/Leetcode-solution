class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited= new int[V];
        
        for(int i=0; i<V; i++)
        {
            if(visited[i]==0)
            {
                if(bfs(adj,i,-1,visited)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static int bfs(ArrayList<ArrayList<Integer>> adj,int node,int parent,int[] visited)
    {
        Queue<Pair<Integer,Integer>> q= new LinkedList<>();

        q.add(new Pair(node,parent));

        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            int node= temp.node;
            int parent= temp.parent;

            for(int adjNode: adj.get(node))
            {
                if(visited[adjNode]==0)
                {
                    visited[adjNode]=1;
                    q.add(new Pair(adjNode,node));
                }
                else if(parent != adjNode)
                {
                    return true;
                }
            }
        }
        return false;
    }