class Pair{
    int prev;
    int cur;
    public Pair(int _prev,int _cur)
    {
        this.prev= _prev;
        this.cur= _cur;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited= new int[V];
        
        for(int i=0; i<V; i++)
        {
            if(visited[i]==0)
            {
                if(dfs(V,adj,i,-1,visited)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int V,ArrayList<ArrayList<Integer>> adj,int node,int parent,int[] visited)
    {
       visited[node]=1;
       
       for(int i: adj.get(node))
       {
           if(visited[i]==0)
           {
               if(dfs(V,adj,i,node,visited)==true)
               {
                   return true;
               }
           }
           else if(i != parent)
           {
               return true;
           }
              
       }
       return false;
    }
}