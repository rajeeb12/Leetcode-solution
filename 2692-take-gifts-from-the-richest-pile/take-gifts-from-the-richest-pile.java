class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int gift: gifts){
            pq.add(gift);
        }
        while(k-- > 0){
            int val = pq.poll();
            pq.add((int)Math.sqrt(val));
        }
        long ans = 0;

        while(!pq.isEmpty()) ans += pq.poll();
        return ans;
    }
}