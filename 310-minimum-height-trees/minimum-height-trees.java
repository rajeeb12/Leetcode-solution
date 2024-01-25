class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int inDegree[] = new int[n];
        for(int i = 0 ;i < n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            return ans;
        }

        for(int e[]: edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            inDegree[v]++;
            inDegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n; i++)
        {
            if(inDegree[i] == 1) q.add(i);
        }

        while(n > 2)
        {
            int size = q.size();
            n -= size;

            for(int i = 0 ; i < size ; i++)
            {
                int node = q.poll();
                for(int adjNode: adj.get(node))
                {
                    inDegree[adjNode]--;
                    if(inDegree[adjNode] == 1)
                    {
                        q.add(adjNode);
                    }
                }
            }
        }
        ans.addAll(q);
        
        return ans;
    }  
}