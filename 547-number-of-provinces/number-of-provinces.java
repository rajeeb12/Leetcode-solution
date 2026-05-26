class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            count++;
            helper(i,isConnected,visited,n);
        }
        return count;
    }
    public void helper(int i,int adj[][],boolean visited[],int n){
        visited[i] = true;
        for(int j = 0; j < n; j++){
            if(!visited[j] && adj[i][j] == 1){
                helper(j, adj,visited, n);
            }
        }
    }
}