class Pair{
    int price;
    int v;
    public Pair(int _p,int _v)
    {
        this.price = _p;
        this.v = _v;
    }
}

class Tuple{
    int price;
    int node;
    int stop;
    public Tuple(int _p,int _node,int _s)
    {
        this.price = _p;
        this.node = _node;
        this.stop = _s;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int flight[] : flights)
        {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            adj.get(u).add(new Pair(price,v)); 
        }

        Queue<Tuple> q = new LinkedList<>();
        int prices[] = new int[n];

        Arrays.fill(prices, (int)1e9);
        q.add(new Tuple(0,src,0));
        prices[src] = 0;

        while(!q.isEmpty())
        {
            Tuple t = q.poll();
            int node = t.node;
            int price = t.price;
            int stop = t.stop;

            if(stop > k) continue;
            for(Pair p : adj.get(node))
            {
                int adjNode = p.v;
                int adjPrice = p.price;
                
                if(adjPrice + price < prices[adjNode] && stop <= k)
                {
                    prices[adjNode] = adjPrice + price;
                    q.add(new Tuple(prices[adjNode], adjNode, stop + 1));
                }
            }
        }
        return (prices[dst] == (int)1e9 ? -1 : prices[dst]);

    }
}