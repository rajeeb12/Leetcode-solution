class Pair{
    int num;
    int freq;
    public Pair(int _n,int _f)
    {
        this.num = _n;
        this.freq = _f;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b) -> a.freq - b.freq);
        for(int i: nums)
        {
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            int num = entry.getKey();
            int freq = entry.getValue();

            pq.add(new Pair(num, freq));

            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        int arr[]= new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int num = p.num;
            int freq = p.freq;
            arr[index++] = num;
        }
        return arr;
    }
}