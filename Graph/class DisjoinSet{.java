class DisjoinSet{
    List<Integer> rank= new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();
    Public DisjoinSet(int V)
    {
        for(int i=0; i<V; i++)
        {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public static int findUparent(int node)
    {
        if(node==parent.node)
        {
            return node;
        }
        int ulp= findUparent(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    public static void unionByRank(int u,int v)
    {
        int ulp_u= findUparent(u);
        int ulp_v= findUparent(v);

        int rank_u= rank.get(ulp_u);
        int rank_v= rank.get(ulp_v);

        if(ulp_u == ulp_v)
        {
            return;
        }
        else if(rank_u > rank_v)
        {
            parent.set(ulp_u,ulp_v);
        }
        else if(rank_v > rank_u)
        {
            parent.set(ulp_v,ulp_u);
        }
        else
        {
            parent.set(ulp_u,ulp_v);
            rank.set(ulp_v, rank_u + 1);
        }
    }
    public static void unionBySize(int u,int v)
    {
        int ulp_u= findUparent(u);
        int ulp_v= findUparent(v);

        int size_u= size.get(ulp_u);
        int size_v= size.get(ulp_v);

        if(ulp_u==ulp_v)
        {
            return;
        }
        if(size_u > size_v)
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size_u + size_v);
        }
        else if(size_v > size_u)
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size_u + size_v);
        }
    }
}