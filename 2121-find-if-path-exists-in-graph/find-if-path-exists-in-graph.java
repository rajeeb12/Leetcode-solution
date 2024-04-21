class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int e[]: edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int visited[] = new int[n];
        return dfs(source,destination, adj, visited);
    }
    public static boolean dfs(int node, int dest,ArrayList<ArrayList<Integer>> adj,int[] visited){
        if(node == dest) return true;
        
        visited[node] = 1;
        for(int adjNode: adj.get(node)){
            if(visited[adjNode] == 0)
            {
                if(dfs(adjNode, dest,adj,visited))
                {
                    return true;
                }
            }
        }
        return false;
    }
}