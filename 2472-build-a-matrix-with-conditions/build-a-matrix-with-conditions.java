class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> op1 = topo_sort(k, rowConditions);
        List<Integer> op2 = topo_sort(k, colConditions);

        if(op1.size() == 0 || op2.size() == 0) return new int[][]{};

        int post_i[] = new int[k + 1];
        int post_j[] = new int[k + 1];
        int ans[][] = new int[k][k];
        for(int i = 0 ; i < k; i++)
        {
            post_i[op1.get(i)] = i;
            post_j[op2.get(i)] = i;
        }

        for(int i = 1; i <= k; i++){
            ans[post_i[i]][post_j[i]] = i;
        }
        return ans;
    }
    public List<Integer> topo_sort(int n,int arr[][]){
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        int indegree[] = new int[n + 1];

        for(int i = 0; i <= n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i[]: arr){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                q.add(i);
            } 
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int node = q.poll();
                ans.add(node);

                for(int adjnode: adj.get(node)){
                    indegree[adjnode]--;
                    if(indegree[adjnode] == 0) q.add(adjnode);
                }
            }
        }
        if(ans.size() != n){
            return new ArrayList<>();
        }
        return ans;
    }
}