class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Queue<Integer> q= new LinkedList<>();
        int[] inDegree= new int[V];
        
        for(int i=0; i<V; i++)
        {
            for(int node : adj.get(i))
            {
                inDegree[node]++;
            }
        }
        for(int i=0; i<V; i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
            }
        }
        int[] ans= new int[V];
        int index=0;
        while(!q.isEmpty())
        {
            int node= q.poll();
            ans[index++]= node;
            for(int i : adj.get(node))
            {
                inDegree[i]--;
                if(inDegree[i]==0)
                {
                    q.add(i);
                }
            }
        }
        return ans;
        
    }
}