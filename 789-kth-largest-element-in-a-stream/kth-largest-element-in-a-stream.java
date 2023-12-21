class KthLargest {
    PriorityQueue<Integer> pq;
    int limit;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        limit = k;
        for(int i: nums)
        {
            pq.add(i);
        }
        while(!pq.isEmpty() && pq.size() > k)
        {
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(!pq.isEmpty() && pq.size() > limit)
        {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */