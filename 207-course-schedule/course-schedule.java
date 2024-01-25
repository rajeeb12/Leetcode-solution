class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int inDegree[] = new int[numCourses];
        
        for(int i = 0; i <numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i[]: p)
        {
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses; i++)
        {
            if(inDegree[i] == 0) q.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty())
        {
            int node =q.poll();

            ans.add(node);
            for(int adjNode: adj.get(node))
            {
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0)
                {
                    q.add(adjNode);
                }
            }
        }
        return (ans.size() == numCourses);
    }
}