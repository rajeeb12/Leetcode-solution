class Solution {
    public int findCenter(int[][] edges) {
        int n = 0;
        for(int i[]: edges){
            n = Math.max(n, Math.max(i[0], i[1]));
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int inDegree[] = new int[n + 1];

        for(int i = 0; i <= n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int e[] : edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            inDegree[u]++;
            inDegree[v]++; 
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i <= n; i++)
        {
            if(inDegree[i] == 1) q.add(i);
        }
        int count = q.size();
        while(count < n)
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                int child = q.poll();
                for(int parent: adj.get(child))
                {
                    inDegree[parent]--;
                    if(inDegree[parent] == 1)
                    {
                        q.add(parent);
                    }
                }
            }
            count += q.size();
        }
        return q.poll();
    }
}