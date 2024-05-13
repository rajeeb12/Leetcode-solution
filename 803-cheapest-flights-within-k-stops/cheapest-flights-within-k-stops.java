class Pair{
    int v;
    int price;
    public Pair(int _v,int _p)
    {
        this.v = _v;
        this.price = _p;
    }
}
class Tuple{
    int v;
    int stops;
    int price;
    public Tuple(int _v,int _s,int _p)
    {
        this.v = _v;
        this.stops = _s;
        this.price = _p;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int f[]: flights)
        {
            int u = f[0];
            int v = f[1];
            int p = f[2];

            adj.get(u).add(new Pair(v, p));
        }
        int dist[] = new int[n];
        Arrays.fill(dist, (int)1e9);
        Queue<Tuple> pq = new LinkedList<>();
        pq.add(new Tuple(src,0,0));
        dist[src] = 0;
        int ans = (int)1e9;

        while(!pq.isEmpty())
        {
            int size = pq.size();
            for(int i = 0; i < size; i++)
            {
                Tuple t = pq.poll();
                int u = t.v;
                int stops = t.stops;
                int price = t.price;

                if(u == dst && stops <= k + 1)
                {
                    ans = Math.min(ans, price);
                } 

                for(Pair p: adj.get(u)){
                    int v = p.v;
                    int adjprice = p.price;
                    if(dist[v] > price + adjprice){
                        dist[v] = price + adjprice;
                        pq.add(new Tuple(v, stops + 1, dist[v]));
                    }
                } 
            }
        }
        return (ans == (int)1e9 ? -1 : ans);
    }
}