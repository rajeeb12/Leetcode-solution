class Pair{
    char ch;
    int count;
    public Pair(char _ch,int _c)
    {
        this.ch = _ch;
        this.count = _c;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b) -> b.count - a.count);
        for(Map.Entry<Character,Integer> entry: map.entrySet())
        {
            char ch = entry.getKey();
            int count = entry.getValue();
        
            pq.add(new Pair(ch, count));
        }
        String res ="";
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int count = p.count;
            char ch = p.ch;

            while(count != 0)
            {
                res += ch;
                count--;
            }
        }
        return res;
    }
}