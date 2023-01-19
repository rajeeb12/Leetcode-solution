class DisjoinSet{
    List<Integer> rank= new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    public DisjoinSet(int n)
    {
        for(int i=0; i<=n; i++)
        {
            rank.add(0);
        }
        for(int i=0; i<=n; i++)
        {
            parent.add(i);
        }
    }
    public int findUltParent(int node)//path Compression is happeing in this fn
    {
        if(node == parent.get(node))
        {
            return node;
        }
        int ulp = findUltParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionByRank(int u,int v)
    {
        int ulp_u= findUltParent(u);
        int ulp_v= findUltParent(v);

        int rank_u= rank.get(ulp_u);
        int rank_v= rank.get(ulp_v);
        if(ulp_u==ulp_v)
        {
            continue;
        }
        else if(rank_u > rank_v)
        {
            parent.set(ulp_v,ulp_u);
        }
        else if(rank_v > rank_u)
        {
            parent.set(ulp_u,ulp_v);
        }
        else
        {
            parent.set(ulp_u,ulp_v);
            rank.set(ulp_v,rank_v + 1);
        }
    }
    public void size(int u,int v)
    {
        int ulp_u= findUltParent(u);
        int ulp_v= findUltParent(v);
        
        int sizeOfu= size.get(ulp_u);
        int sizeOfv= size.get(ulp_v);
        if(ulp_u == ulp_v) continue;
        if(sizeOfu > sizeOfv)
        {
            parent.set(ulp_v,ulp_u);
            size.set(sizeOfu, sizeOfu + sizeOfv);
        }
        else{
            parent.set(ulp_u,ulp_v);
            size.set(sizeOfu, sizeOfu + sizeOfv);
        }
    }

}