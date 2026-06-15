class SmallestInfiniteSet {
    HashSet<Integer> set;
    PriorityQueue<Integer> pq;
    public SmallestInfiniteSet() {
        set = new HashSet<>();
        pq = new PriorityQueue<>();
        for(int i = 1; i < 1001; i++){
            set.add(i);
            pq.add(i);
        }
    }
    
    public int popSmallest() {
        int num = pq.poll();
        set.remove(num);
        return num;
    }
    
    public void addBack(int num) {
        if(set.contains(num)) return;
        set.add(num);
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */