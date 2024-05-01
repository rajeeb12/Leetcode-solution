class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int inDegree[] = new int[n];
        for(int i =0 ; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int e[]: edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            inDegree[u]++;
            inDegree[v]++;
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        if(n == 1)
        {
            ans.add(0);
            return ans;
        }
        for(int i = 0; i < n; i++)
        {
            if(inDegree[i] == 1)
            {
                q.add(i);
            }
        }
        while(n > 2){
            int size = q.size();
            n -= size;

            for(int i = 0; i < size; i++)
            {
                int node =q.poll();
                for(int adjnode: adj.get(node))
                {
                    inDegree[adjnode]--;
                    if(inDegree[adjnode] == 1)
                    {
                        q.add(adjnode);
                    }
                }
            }
        }
        while(!q.isEmpty()) ans.add(q.poll());
        return (ans);

    }
}