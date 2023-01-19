class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for(int edge[]: edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        for(int i=0; i<n; i++)
        {
            dfs(i,i,adj,ans,new boolean[n]);
        }
        return ans;
    }
    public static void dfs(int node,int ancestor,List<List<Integer>> adj,List<List<Integer>> ans,boolean[] seen)
    {
        seen[node]= true;
        for(int adjNode: adj.get(node))
        {
            if(seen[adjNode]) continue; // run test case once

            ans.get(adjNode).add(ancestor);
            dfs(adjNode,ancestor,adj,ans,seen);
        }
    }
    
}