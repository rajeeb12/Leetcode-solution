class Disjoinset{
    int parent[];
    int size[];
    public Disjoinset(int n)
    {
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i =0 ; i <=n ; i++)
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
    public void unionBySize(int node1, int node2)
    {
        int up1 = getParent(node1);
        int up2 = getParent(node2);

        int size1 = size[up1];
        int size2 = size[up2];
        if(up1 == up2) return;
        if(size1 == size2)
        {
            parent[up1] = up2;
            size[up2] *= 2;
        }
        else if(size[up1] < size[up2])
        {
            parent[up1] = up2;
            size[up2] += size[up1]; 
        }
        else{
            parent[up2] = up1;
            size[up1] += size[up2]; 
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int i[]: stones)
        {
            maxRow = Math.max(maxRow , i[0]);
            maxCol = Math.max(maxCol , i[1]);
        }
        Disjoinset ds = new Disjoinset(maxRow + maxCol + 1); 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i[]: stones)
        {
            int node1 = i[0]; // row
            int node2 = maxRow + i[1] + 1; // col
            int up1 = ds.getParent(node1);
            int up2 = ds.getParent(node2);
            if(up1 == up2) continue;
            ds.unionBySize(node1, node2);
            map.put(node1, 1);
            map.put(node2, 1);
        }
        int components = 0;

        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if(ds.getParent(entry.getKey()) == entry.getKey())
            {
                components++;
            }
        }
        return (n - components);
    }
}