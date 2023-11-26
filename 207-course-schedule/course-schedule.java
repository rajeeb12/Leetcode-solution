class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int inDegree[]= new int[numCourses];
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        int n = numCourses;

        for(int i =0 ; i < n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i[]: prerequisites)
        {
            int u = i[0];
            int v = i[1];

            inDegree[v]++;
            adj.get(u).add(v);
        }
    
        Queue<Integer> q= new LinkedList<>();
        for(int i = 0 ; i < n; i++)
        {
            if(inDegree[i] == 0) q.add(i);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        while(!q.isEmpty())
        {
            int node = q.poll();
            temp.add(node);

            for(int adjNode : adj.get(node)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0)
                {
                    q.add(adjNode);
                }
            }
        }
        return (temp.size() == n ? true : false);
    }
}