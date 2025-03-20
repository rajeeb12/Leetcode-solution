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
        int up = findParent(u);
        int vp = findParent(v);

        if(up == vp) return;

        if(size[up] > size[vp]){
            size[up] += size[vp];
            parent[vp] = up;
        }else if(size[vp] > size[up]){
            size[vp] += size[up];
            parent[up] = vp;
        }else{
            size[up] += size[vp];
            parent[vp] = up;
        }
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
            if(upu == upv){
                ans[upu] &= wt;
            }
            int temp = ans[upu] & ans[upv];
            ds.unionBySize(u, v);
            int up = ds.findParent(u);
            ans[up] = temp; 
            ans[up] &= wt;
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