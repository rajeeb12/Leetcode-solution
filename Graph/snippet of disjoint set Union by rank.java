class DisjointSet{
    List<Integer> rank= new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    
    public DisjointSet(int n)
    {
        for(int i=0; i<=n; i++)
        {
            rank.add(0);
            parent.add(i);
        }
    }
    
    //Path compression
    public int findUparent(int node)//O(logn)
    {
        if(node == parent.get(node))
        {
            return node;
        }
        int ulp = findUparent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    //
    void unionByRank(int u,int v)
    {
        int ulp_u= findUparent(u);
        int ulp_v= findUparent(v);
        if(ulp_u == ulp_v)
        {
            return;
        }
        else if(rank.get(ulp_u) < rank.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u))
        {
            parent.set(ulp_v,ulp_u);
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            int rankU= rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
    
}