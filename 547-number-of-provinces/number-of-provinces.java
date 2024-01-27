class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0 ; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0; j < n ; j++)
            {
                if(i == j) continue;
                if(isConnected[i][j] != 0)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int visit[] = new int[n];

        for(int i = 0 ; i < n ; i++)
        {
            if(visit[i] == 0)
            {
                count++;
                dfs(i,adj,visit);
            }
        }
        return count;
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj , int[] visit)
    {
        visit[node] = 1;

        for(int adjNode: adj.get(node))
        {
            if(visit[adjNode] == 0)
            {
                dfs(adjNode,adj,visit);
            }
        }
    }
}