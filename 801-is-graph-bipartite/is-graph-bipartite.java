class Solution {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        int n= graph.length;
        for(int i = 0 ; i < n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        int colorArray[]= new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            int m = graph[i].length;
            for(int j = 0 ; j < m ;j++)
            {
                adj.get(i).add(graph[i][j]);
            }
        }
        Arrays.fill(colorArray, -1);
        
        for(int i = 0 ; i < n; i++)
        {
            if(colorArray[i] == -1)
            {
                if(dfs(i,0,colorArray,adj) == false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int color,int[] colorArray,ArrayList<ArrayList<Integer>> adj)
    {
        colorArray[node] = color;

        for(int adjNode: adj.get(node))
        {
            if(colorArray[adjNode] == -1)
            {
                if(dfs(adjNode , 1 - color ,colorArray,adj) == false)
                {
                    return false;
                }
            }
            else if(colorArray[adjNode] == color){
                return false;
            }
        }
        return true;
    }
}