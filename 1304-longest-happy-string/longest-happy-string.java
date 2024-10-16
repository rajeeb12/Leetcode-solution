class Pair{
    char c;
    int num;
    public Pair(char _c,int _num){
        this.c = _c;
        this.num = _num;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(( d, e) -> e.num - d.num);
        if(a > 0) pq.add(new Pair('a', a));
        if(b > 0) pq.add(new Pair('b', b));
        if(c > 0) pq.add(new Pair('c', c));
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            Pair first = pq.poll();

            if(ans.length() != 0 && ans.charAt(ans.length() - 1) == first.c)
            {
                if(pq.isEmpty()) break;
                
                Pair second = pq.poll();

                if(second.num >= 1){
                    ans.append(second.c);
                    second.num -= 1;
                }

                if(second.num > 0) pq.add(second);
                pq.add(first);
            }else{
                if(first.num >= 2){
                    ans.append(first.c +""+first.c);
                    first.num -= 2;
                }else if(first.num >= 1)
                {
                    ans.append(first.c);
                    first.num -= 1;
                }
                if(first.num > 0) pq.add(first);
            }
        }
        return ans.toString();
    }
}