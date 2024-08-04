class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++){
            adj.get(i).add(i + 1);
        }
        int dist[] = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = i;
        }
        int ans[] = new int[queries.length];
        int index = 0;
        
        for(int i[] : queries){
            adj.get(i[0]).add(i[1]);
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
        
            while(!q.isEmpty())
            {
                int size = q.size();
                for(int it = 0; it < size; it++)
                {
                    int node = q.poll();
                    for(int adjnode: adj.get(node))
                    {
                        if(dist[node] + 1 <= dist[adjnode])
                        {
                            dist[adjnode] = dist[node] + 1;
                            q.add(adjnode); 
                        }
                    }
                }
            }
            ans[index++] = dist[n - 1];
        }
        return ans; 
    }
}