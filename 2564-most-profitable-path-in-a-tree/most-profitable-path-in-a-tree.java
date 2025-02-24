class Solution {
    HashMap<Integer, Integer> map;
    int ans;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= edges.length; i++){
            adj.add(new ArrayList<>());
        }    
        for(int e[]: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        ans = -(int)1e9;
        map = new HashMap<>();
        dfs(bob,0, new HashSet<>(), adj);
        solve(0,0, 0, new HashSet<>(), adj, amount);
        return ans;
    }
    public void solve(int curSum,int aliceNode,int time, HashSet<Integer> set, List<List<Integer>> adj,int[] amount){
        set.add(aliceNode);
        if(!map.containsKey(aliceNode) || time < map.get(aliceNode)){
            curSum += amount[aliceNode];
        }else if(time == map.get(aliceNode)){
            curSum += amount[aliceNode] / 2;
        }

        if(adj.get(aliceNode).size() == 1 && aliceNode != 0){
            ans = Math.max(ans, curSum);
            return;
        }

        for(int adjAliceNode: adj.get(aliceNode)){
            if(!set.contains(adjAliceNode)) solve(curSum , adjAliceNode, time + 1, set, adj, amount);
        }

    }
    public boolean dfs(int node,int time, HashSet<Integer> set,List<List<Integer>> adj){
        set.add(node);
        map.put(node, time);

        if(node == 0) return true;
        
        for(int adjNode: adj.get(node)){
            if(!set.contains(adjNode)){
                if(dfs(adjNode, time + 1, set, adj)){
                    return true;
                }
            }
        }

        map.remove(node);
        return false;
    }
}