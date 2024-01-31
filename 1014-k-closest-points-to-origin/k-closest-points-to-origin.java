class Tuple{
    int value;
    int x;
    int y;
    public Tuple(int _v,int _x,int _y)
    {
        this.value = _v;
        this.x = _x;
        this.y = _y;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> b.value - a.value);

        for(int i[]: points)
        {
            int x = i[0];
            int y = i[1];

            int value = x * x + y * y;
            pq.add(new Tuple(value, x, y));

            while(!pq.isEmpty() && pq.size() > k)
            {
                pq.poll();
            }
        }
        int ans[][] = new int[pq.size()][2];
        int index = 0;
        while(!pq.isEmpty())
        {
            Tuple temp= pq.poll();
            int x = temp.x;
            int y = temp.y;
            ans[index][0] = x;
            ans[index][1] = y;
            index++;
        }
        return ans;
    }
}