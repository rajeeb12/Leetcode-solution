class Solution {
    int ans = 0;
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int conn[]: connections){
            int u = conn[0];
            int v = conn[1];
            adj.get(u).add(new int[]{v, 1});
            adj.get(v).add(new int[]{u, 0});
        }
        boolean visited[] = new boolean[n];
        dfs(0,adj,visited);
        return ans;
    }
    public void dfs(int node,List<List<int[]>> adj,boolean visited[]){
        visited[node] = true;
        List<int[]> adjNodes = adj.get(node);
        for(int[] adjNode: adjNodes){
            if(!visited[adjNode[0]]){
                ans += adjNode[1];
                dfs(adjNode[0], adj, visited);
            }
        }
    }
    
}