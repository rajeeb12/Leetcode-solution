class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for(int i: stones)
        {
            pq.add(i);
        }

        while(!pq.isEmpty() && pq.size() > 1)
        {
            int value1 = pq.poll();
            int value2 = pq.poll();
            int diff = Math.abs(value1 - value2);
            if(diff == 0) continue;
            pq.add(diff);
        }
        return (pq.size() == 0 ? 0 : pq.poll());
    }
}