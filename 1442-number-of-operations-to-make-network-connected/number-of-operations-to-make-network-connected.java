class DisjointSet{
	int[] parent;
    int[] size;
	public DisjointSet(int n)
	{
		parent = new int[n+1];
        size = new int[n+1];
        for(int i =0 ; i <= n ; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
	}
// path compression
	public int getParent(int node)
	{
	    if(parent[node] == node)
	    {
	        return node;
	    }
	    parent[node] = getParent(parent[node]);
	
	    return parent[node];
	}
	
  public void unionBySize(int node1, int node2)
   {
        int up1 = getParent(node1);
        int up2 = getParent(node2);
        
        int size1 = size[up1];
        int size2 = size[up2];
        if(up1 == up2) return;
        
        if(size1 == size2)
        {
            parent[up2] = up1;
            size[up1] *= 2; 
        }else if(size1 < size2)
        {
            parent[up1] = up2;
            size[up2] += size[up1];
        }else{
            parent[up2] = up1;
            size[up1] += size[up2];
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int count = 0;
        DisjointSet ds = new DisjointSet(n);

        for(int connection[]: connections)
        {
            int u = connection[0];
            int v = connection[1]; 
            int up1 = ds.getParent(u);
            int up2 = ds.getParent(v);
            if(up1 == up2){
                count++;
                continue;
            }
            ds.unionBySize(u,v);
        }
        int countComponents = 0;
        for(int i =0 ; i<n; i++)
        {
            if(ds.parent[i] == i)
            {
                countComponents++;
            }
        }
        return (count >= countComponents-1 ? countComponents-1 : -1);
    }
}