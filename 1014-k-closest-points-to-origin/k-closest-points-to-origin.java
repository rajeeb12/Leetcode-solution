class Tuple{
    int dist;
    int x;
    int y;
    public Tuple(int _d,int _x,int _y)
    {
        this.dist = _d;
        this.x = _x;
        this.y = _y;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple> pq= new PriorityQueue<>((a,b) -> b.dist - a.dist);

        for(int i[]: points)
        {
            int x = i[0];
            int y = i[1];
            int dist = (int) ((x * x) + (y * y));
            pq.add(new Tuple(dist, x ,y));

            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        int ans[][]= new int[k][2];

        int index = 0;

        while(!pq.isEmpty())
        {
            Tuple t = pq.poll();
            int x = t.x;
            int y = t.y;
            ans[index][0] = x;
            ans[index][1] = y;
            index++;
        }

        return ans;

    }
}