class RecentCounter {
    int track[];
    int start;
    int end;
    public RecentCounter() {
        track = new int[(int)1e4];
        start = 0;
        end = 0;
    }
    
    public int ping(int t) {
        while(start < end && t - 3000 > track[start]) start++;
        track[end++] = t;
        return end - start;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */