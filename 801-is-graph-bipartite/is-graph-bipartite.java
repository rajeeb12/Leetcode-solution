class Solution {
    public boolean isBipartite(int[][] graph) {
        int  n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i= 0 ; i < n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < graph[i].length; j++)
            {
                int u = i;
                int v = graph[i][j];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int color[] = new int[n];
        Arrays.fill(color, -1);

        for(int k = 0 ; k < n ; k++)
        {
            if(color[k] == -1)
            {
                color[k] = 0;
                q.add(k);

                while(!q.isEmpty())
                {
                    int size = q.size();
                    for(int i = 0 ; i < size ; i++)
                    {
                        int node = q.poll();
                        int value= color[node];

                        for(int adjNode: adj.get(node))
                        {
                            if(color[adjNode] == -1)
                            {
                                color[adjNode] = 1 - value;
                                q.add(adjNode);
                            }else if(color[adjNode] == value)
                            {
                                
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
}