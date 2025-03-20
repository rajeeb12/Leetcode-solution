class DisjointSet{
    int parent[];
    int size[];
    public DisjointSet(int n){
        size = new int[n + 1];
        parent = new int[n + 1];
        for(int i = 0; i < n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int u){
        if(parent[u] == u) return u;
        parent[u] = findParent(parent[u]);
        return parent[u];
    }

    public void unionBySize(int u,int v){
        parent[v] = u;
    }
}
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds = new DisjointSet(n);
        int ans[] = new int[n];

        Arrays.fill(ans , -1);
        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            int upu = ds.findParent(u);
            int upv = ds.findParent(v);
            if(upu != upv){
                ds.unionBySize(upu, upv);
                ans[upu] &= ans[upv];
            }
            ans[upu] &= wt;
        }

        int finalAns[] = new int[query.length];
        int index = 0;
        for(int q[]: query){
            int u = q[0];
            int v = q[1];

            int upu = ds.findParent(u);
            int upv = ds.findParent(v);
            if(upu != upv){
                finalAns[index] = -1;
            }else{
                finalAns[index] = ans[upu];
            }
            index++;
        }
        return finalAns;
    }
}