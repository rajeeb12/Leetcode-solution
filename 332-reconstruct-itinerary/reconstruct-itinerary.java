class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String , PriorityQueue<String>> adj = new HashMap<>();
        LinkedList<String> ans = new LinkedList<>();

        for(List<String> ls: tickets)
        {
            if(!adj.containsKey(ls.get(0)))
            {
                adj.put(ls.get(0), new PriorityQueue<String>()); 
            }
            adj.get(ls.get(0)).add(ls.get(1));
        }
        dfs("JFK", adj, ans);
        return ans;
    }
    public void dfs(String node, HashMap<String , PriorityQueue<String>> adj, LinkedList<String> ans)
    {
        PriorityQueue<String> pq = adj.get(node);
        
        while(pq != null && !pq.isEmpty())
        {
            String adjNode = pq.poll();
            dfs(adjNode, adj, ans);
        }
        ans.addFirst(node);
    }
}