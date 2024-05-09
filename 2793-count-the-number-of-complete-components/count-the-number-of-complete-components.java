class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
    
        for(int e[]: edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(!visited[i] && solve(i,adj,visited))
            {
                count++;
            }
        }
        return count;
    }
    public boolean solve(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        int count = adj.get(node).size();
        boolean iscomponent = true;
        int countneigh = 0;
      
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size; i++)
            {
                node = q.poll();
                countneigh++;
                for(int adjnode: adj.get(node))
                {
                    if(adj.get(adjnode).size() != count) return false;
                    if(!visited[adjnode])
                    {
                        q.add(adjnode);
                        visited[adjnode] = true;
                    }
                }
            }
        }
        return iscomponent && count == countneigh - 1; 
    }
    
}