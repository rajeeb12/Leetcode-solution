class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited= new int[V];
        int[] pathVisited= new int[V];
        
        boolean flag= false;
        
        for(int i=0; i<V; i++)
        {
            if(visited[i]==0)
            {
                if(dfs(i,adj,visited,pathVisited))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,int[] pathVisited)
    {
        visited[node]= 1;
        pathVisited[node]=1;
        
        for(int adjNode: adj.get(node))
        {
            if(visited[adjNode]==0)
            {
                if(dfs(adjNode,adj,visited,pathVisited))
                {
                    return true;
                }
            }
            else if(pathVisited[adjNode]==1)
            {
                return true;
            }
        }
        pathVisited[node]= 0;
        return false;
    }
}