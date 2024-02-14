class Disjoint{
    int[] parent;
    int[] size;
    public Disjoint(int n)
    {
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0 ; i <= n; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int getParent(int node)
    {
        if(parent[node] == node)
        {
            return node;
        }
        parent[node] = getParent(parent[node]);
        return parent[node];
    }
    public void unionBysize(int node1,int node2)
    {
        int p1 = getParent(node1);
        int p2 = getParent(node2);
        if(p1 == p2) return;

        int p1size = size[p1];
        int p2size = size[p2];
        if(p1size == p2size)
        {
            parent[p1] = p2;
            size[p2] *= 2;
        }
        else if(p1size < p2size)
        {
            parent[p1] = p2;
            size[p2] += size[p1];
        }else{
            parent[p2] = p1;
            size[p1] += size[p2];
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Disjoint d = new Disjoint(n);

        for(int edge[]: edges)
        {
            int u = edge[0];
            int v = edge[1];
            int p1 = d.getParent(u);
            int p2 = d.getParent(v);
            if(p1 == p2)
            {
                int temp[] = {u,v};
                return temp;
            }
            else{
                d.unionBysize(u,v);
            }
        }
        return new int[]{0,0};
    }
}