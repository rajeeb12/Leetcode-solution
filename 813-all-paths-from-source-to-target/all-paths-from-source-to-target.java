class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, n - 1, ans,new ArrayList<>(), graph);
        return ans;
    }
    public void solve(int src,int target,List<List<Integer>> ans, List<Integer> temp,int[][] graph)
    {
        temp.add(src);
        if(src == target)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int adjNode: graph[src])
        {
            solve(adjNode,target,ans,temp,graph);
            temp.remove(temp.size() - 1);
        }
    }
}