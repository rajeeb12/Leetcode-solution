class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] != 0) adj.get(i).add(j);
            }
        }
        int count = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            count++;
            helper(i,adj,visited);
        }
        return count;
    }
    public void helper(int node,List<List<Integer>> adj,boolean visited[]){
        visited[node] = true;
        for(int i = 0; i < adj.get(node).size(); i++){
            int adjNode = adj.get(node).get(i);
            if(!visited[adjNode]){
                helper(adjNode, adj, visited);
            }
        }
    }
}