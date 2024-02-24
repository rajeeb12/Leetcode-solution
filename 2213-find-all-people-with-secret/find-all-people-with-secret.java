class Pair{
    int v;
    int time;
    public Pair(int _v,int _t)
    {
        this.v = _v;
        this.time = _t;
    }
}
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i[]: meetings)
        {
            int u = i[0];
            int v = i[1];
            int time = i[2];
            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u, time));
        }
        PriorityQueue<Pair> pq =new PriorityQueue<>((a,b) -> a.time - b.time);
        int visited[] = new int[n];
        List<Integer> ans = new ArrayList<>();

        pq.add(new Pair(0,0));
        pq.add(new Pair(firstPerson, 0));

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int node = p.v;
            int time = p.time;
            
            if(visited[node] == 1) continue;
            visited[node] = 1;
            for(Pair it: adj.get(node))
            {
                int adjNode = it.v;
                int adjtime = it.time;

                if(visited[adjNode] == 0 && adjtime >= time)
                {
                    pq.add(new Pair(adjNode,adjtime));
                }
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
            if(visited[i] == 1) ans.add(i);
        }
        return ans;
    }
}