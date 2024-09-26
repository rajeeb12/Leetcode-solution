class MyCalendar {
    List<int[]> ls;
    public MyCalendar() {
        ls = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] it: ls){
            if(Math.max(it[0], start) < Math.min(it[1] , end)) return false;
        }

        ls.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */