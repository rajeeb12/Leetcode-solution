class Disjoint{
    int size[];
    int parent[];
    public Disjoint(int n){
        size = new int[n + 1];
        parent = new int[n + 1];

        for(int i = 0; i <= n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }
    public int getParent(int node){
        if(parent[node] == node) return node;

        return parent[node] = getParent(parent[node]);
    }
    public void union(int node1,int node2){
        int up1 = getParent(node1);
        int up2 = getParent(node2);

        if(up1 == up2){
            size[up1] =2 * size[up1];
        }else if(size[up1] > size[up2]){
            parent[up2] = up1;
            size[up1] += size[up2];
        }else{
            parent[up1] = up2;
            size[up2] += size[up1]; 
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        Disjoint ds = new Disjoint(1001);
        int n = stones.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                {
                    ds.union(i, j);
                }
            }
        }
        int parent[] = ds.parent;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                count++;
            }
        }
        return n - count;
    }
}