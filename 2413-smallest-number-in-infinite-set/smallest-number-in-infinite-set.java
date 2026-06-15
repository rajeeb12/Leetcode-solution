class SmallestInfiniteSet {
    int minNum;
    PriorityQueue<Integer> pq;
    public SmallestInfiniteSet() {
        minNum = 1;
        pq= new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if(!pq.isEmpty()) return pq.poll();
        minNum++;
        return minNum - 1;
    }
    
    public void addBack(int num) {
        if(minNum > num && !pq.contains(num)) pq.add(num);
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */