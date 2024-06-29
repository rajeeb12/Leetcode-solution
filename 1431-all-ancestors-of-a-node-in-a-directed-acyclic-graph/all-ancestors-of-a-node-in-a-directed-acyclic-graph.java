class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }

        for(int e[]: edges){
            adj.get(e[1]).add(e[0]);
        }
        
        for(int node = 0; node < n; node++){
            List<Integer> ls = new ArrayList<>();
            int visited[] = new int[n];
            solve(node,adj,visited,ls);
            Collections.sort(ls);
            ans.get(node).addAll(ls);
        }
        return ans;
    }
    public void solve(int node,List<List<Integer>> adj, int[] visited,List<Integer> ls)
    {
        visited[node] = 1;

        for(int adjnode: adj.get(node))
        {
            if(visited[adjnode] == 0){
                ls.add(adjnode);
                solve(adjnode, adj, visited, ls);
            }
        }
    }
}