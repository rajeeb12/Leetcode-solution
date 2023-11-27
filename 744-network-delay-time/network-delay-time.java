class Pair{
    int time;
    int node;
    public Pair(int _t,int _n){
        this.time = _t;
        this.node = _n;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int time[]: times){
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adj.get(u).add(new Pair(t, v));
        }
        Queue<Pair> q = new LinkedList<>();
        int ans[] = new int[n + 1];
        
        Arrays.fill(ans, (int)1e9);
        q.add(new Pair(0,k));
        ans[k] = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int time = p.time;

            for(Pair t: adj.get(node)){
                int adjNode = t.node;
                int adjTime = t.time;
                if(adjTime + time < ans[adjNode]){
                    ans[adjNode] = adjTime + time;
                    q.add(new Pair(ans[adjNode] , adjNode));
                }
            }
        } 
        int max = 0;
        for(int i = 1; i<=n; i++)
        {
            if(ans[i] ==(int)1e9){
                return -1;
            }
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}