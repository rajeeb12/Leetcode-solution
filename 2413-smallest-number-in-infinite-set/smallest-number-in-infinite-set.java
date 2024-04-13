class SmallestInfiniteSet {
    TreeSet<Integer> t;
    int min;
    public SmallestInfiniteSet() {
        t = new TreeSet<>();
        for(int i = 1; i <= 1000; i++){
            t.add(i);
        }
    }
    
    public int popSmallest() {
        return t.pollFirst();
    }
    
    public void addBack(int num) {
        t.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */