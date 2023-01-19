class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> adj= new ArrayList<>();
        int[] inDegree= new int[n];
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int rich[]: richer)
        {
            adj.get(rich[0]).add(rich[1]);
            inDegree[rich[1]]++;
        }
        int ans[]= new int[n];
        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            if(inDegree[i]==0) q.add(i);
            ans[i]= i;
        }

        while(!q.isEmpty())
        {
            int node= q.poll();

            for(int adjNode : adj.get(node))
            {
                if(quiet[adjNode] > quiet[node])
                {
                    quiet[adjNode] = quiet[node];
                    ans[adjNode]= ans[node]; 
                }
                inDegree[adjNode]--;
                if(inDegree[adjNode]==0) q.add(adjNode);
            }
        }
        return ans;
    }
    
}