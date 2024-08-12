class Disjoint{
    int size[];
    int parent[];
    public Disjoint(int n){
        size = new int[n + 1];
        parent = new int[n + 1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int getParent(int node){
        if(parent[node] == node){
            return node;
        }
        parent[node] = getParent(parent[node]);
        return parent[node];
    }
    public void union(int u,int v){
        int up1 = getParent(u);
        int up2 = getParent(v);

        if(size[up1] == size[up2]){
            parent[up2] = up1;
            size[up1] += size[up2];
        }else if(size[up1] < size[up2]){
            parent[up1] = up2;
            size[up2] += size[up1];
        }else{
            parent[up2] = up1;
            size[up1] += size[up2];
        }
    }
}
class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length + 1; 
        Disjoint dsu = new Disjoint(n*n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == n - 1){
                    int cellnumber = i * n + j;
                    if(cellnumber != 0) dsu.union(0, cellnumber);
                }
            }
        }
        int count = 1;
        for(int i = 0; i < grid.length; i++){
            char arr[] = grid[i].toCharArray();
            for(int j = 0; j < arr.length; j++)
            {    
                if(arr[j] == '\\'){
                    int x = i * n + j;
                    int y = (i + 1) * n + (j + 1);
                    if(dsu.getParent(x) == dsu.getParent(y))
                    {
                        count++;
                    }else{
                        dsu.union(x, y);
                    }
                }else if(arr[j] == '/'){
                    int x = i * n + (j + 1);
                    int y = (i + 1) * n + j;
                    if(dsu.getParent(x) == dsu.getParent(y))
                    {
                        count++;
                    }else{
                        dsu.union(x, y);
                    }
                }
            }
        }
        return count;
    }
}