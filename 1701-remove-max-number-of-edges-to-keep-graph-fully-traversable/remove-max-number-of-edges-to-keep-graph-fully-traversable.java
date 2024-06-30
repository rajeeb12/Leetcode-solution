class DSU{
    int[] parent;
    int[] size;
    int component;
    public DSU(int n){
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0 ; i <= n; i++){
            parent[i] = i;
        }
        Arrays.fill(size, 1);
        component = n;
    }

    public int getParent(int node){
        if(node == parent[node]) return node;

        return parent[node] = getParent(parent[node]);
    }

    public void addBySize(int node1,int node2){
        int up1 = getParent(node1);
        int up2 = getParent(node2);

        if(up1 == up2)
        {
            return;
        }else if(size[up1] == size[up2]){
            parent[up2] = up1;
            size[up1] = 2 * size[up2];
        }
        else if(size[up1] > size[up2])
        {
            size[up1] += size[up2];
            parent[up2] = up1;
        }else{
            size[up2] += size[up1];
            parent[up1] = up2;
        }
        component--;
    }
    public boolean isSingle(){
        return (component == 1);
    }

}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        Arrays.sort(edges, (a,b) -> b[0] - a[0]);
        int count = 0;

        for(int e[]: edges){
            int type = e[0];
            int u = e[1];
            int v = e[2];
            int upa1 = alice.getParent(u);
            int upa2 = alice.getParent(v);
            
            int upb1 = bob.getParent(u);
            int upb2 = bob.getParent(v);

            if(type == 3)
            {
                boolean flag = false;
                if(upa1 != upa2)
                {
                    flag = true;
                    alice.addBySize(u,v);
                }
                if(upb1 != upb2)
                {
                    flag = true;
                    bob.addBySize(u, v);
                }
                if(flag) count += 1;
            }else if(type == 2)
            {
                if(upb1 != upb2){
                    count++;
                    bob.addBySize(u,v);
                }
            }else{
                if(upa1 != upa2){
                    count++;
                    alice.addBySize(u,v);
                }
            }
        }
        
        int upa = alice.getParent(1);
        int upb = bob.getParent(1);
        // System.out.print(count+" "+alice.size[upa] +" "+bob.size[upb]);
        if(alice.isSingle() && bob.isSingle()) return edges.length - count;

        return -1;
    }
}