class CountIntervals {
    TreeMap<Integer,Integer> map;
    int count;
    public CountIntervals() {
        map = new TreeMap<>();
        count = 0;
    }
    
    public void add(int left, int right) {
        int l = left;
        int r = right;
        
        while((map.floorKey(r) != null) && (map.get(map.floorKey(r)) >= l))
        {
            int minL= map.floorKey(r);
            int maxR = map.get(minL);

            count -= (maxR - minL + 1);
            map.remove(minL);

            l = Math.min(l, minL);
            r = Math.max(r, maxR);
        }
        map.put(l, r);
        count += (r - l + 1);
    }
    
    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */