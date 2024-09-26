class MyCalendar {
    TreeSet<int[]> set;
    public MyCalendar() {
        set = new TreeSet<>((a,b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
        int book[] = new int[]{start, end};
        int[] floor = set.floor(book);
        int[] ceil = set.ceiling(book);
        if(floor != null && start < floor[1]) return false;
        if(ceil != null && ceil[0] < end) return false;
        
        set.add(book);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */