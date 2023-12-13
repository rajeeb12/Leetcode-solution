class Solution {
    public int findCenter(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length + 1; 

        for(int i = 0 ; i <= n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int e[]: edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans = 0;
        for(int i = 1 ; i <= n ; i++)
        {
            if(adj.get(i).size() == n-1){
                return i;
            }
        }
        return -1;
    }
}