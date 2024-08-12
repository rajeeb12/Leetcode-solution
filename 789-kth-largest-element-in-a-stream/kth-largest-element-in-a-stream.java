class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int _k, int[] nums) {
        pq = new PriorityQueue<>();
        k = _k;
        for(int i: nums){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
    }
    
    public int add(int val) {
       
        pq.add(val);
        if(pq.size() > k){
            pq.poll();
        }
        return (pq.isEmpty() ? 0 : pq.peek());
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */