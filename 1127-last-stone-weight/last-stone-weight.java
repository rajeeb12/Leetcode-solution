class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: stones)
        {
            pq.add(i);
        }
        while(pq.size() > 1)
        {
            int s1 = pq.poll();
            int s2 = pq.poll();

            int opValue = s1 - s2;
            if(opValue == 0) continue;
            pq.add(opValue);
        }
        return (pq.size() == 0 ? 0 : pq.poll());
    }
}