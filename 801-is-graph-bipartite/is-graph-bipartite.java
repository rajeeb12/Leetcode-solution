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
        int color[] = new int[n];
        Arrays.fill(color, -1);

        for(int k = 0 ; k < n ; k++)
        {
            if(color[k] == -1)
            {
                if(!dfs(k, color,1, adj)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int parent, int[] color,int c, ArrayList<ArrayList<Integer>> adj)
    {
        color[parent] = c;

        for(int child: adj.get(parent))
        {
            if(color[child] == -1)
            {
                if(dfs(child, color, 1 - c, adj) == false) return false;
            }else if(color[child] == c)
            {
                return false;
            }
        }
        return true;
    }
}