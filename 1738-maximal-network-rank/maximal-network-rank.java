class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> adj = new ArrayList<>();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        // for(int i = 0 ; i < n; i++)
        // {
        //     adj.add(new ArrayList<>());
        // }
        if(roads.length == 0) return 0;
        int indegree[] = new int[n];
        for(int road[]: roads)
        {
            int u = road[0];
            int v = road[1];
            if(!map.containsKey(u))
            {
                map.put(u, new HashSet<>());
            }
            if(!map.containsKey(v))
            {
                map.put(v, new HashSet<>());
            }

            map.get(u).add(v);
            map.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        int maxrank = 0;
        for(int node = 0 ; node < n - 1; node++)
        {
            for(int adjnode = node + 1; adjnode < n; adjnode++)
            {
                if(!map.containsKey(adjnode) || !map.containsKey(node)) continue;
                HashSet<Integer> nodeTemp = map.get(node);
                int idAdjnode = indegree[adjnode];
                int idNode = indegree[node];
                int currentans = idAdjnode + idNode;
                if(nodeTemp.size() > 0 && nodeTemp.contains(adjnode))
                {
                    currentans--;
                }
                maxrank = Math.max(currentans, maxrank);
            }
        }
        return maxrank;
    }
}