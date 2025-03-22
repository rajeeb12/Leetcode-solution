class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int visited[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0 && bfs(i, visited, adj)) count++;
        }
        return count;
    }
    public boolean bfs(int node,int[] visited,List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int countNeighbor = 0;
        int size = adj.get(node).size();
        visited[node] = 1;
        while(!q.isEmpty()){
            int qsize = q.size();

            for(int i = 0; i < qsize; i++){
                int u = q.poll();
                countNeighbor++;
                for(int v: adj.get(u)){
                    if(adj.get(v).size() != size) return false;
                    if(visited[v] == 0){
                        q.add(v);
                        visited[v] = 1;
                    }
                }
            }
        } 
        return (size == countNeighbor - 1);
    }
}