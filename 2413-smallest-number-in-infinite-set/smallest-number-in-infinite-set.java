class SmallestInfiniteSet {
    TreeSet<Integer> t;
    int min;
    public SmallestInfiniteSet() {
        t = new TreeSet<>();
        min = 1; 
    }
    
    public int popSmallest() {
        if(t.isEmpty()) return min++;
        return t.pollFirst();
    }
    
    public void addBack(int num) {
        if(num < min) t.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */