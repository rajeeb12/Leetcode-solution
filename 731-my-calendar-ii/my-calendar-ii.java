class MyCalendarTwo {
    List<int[]> ls;
    public MyCalendarTwo() {
        ls = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        MyCalendar overlap = new MyCalendar();
        for(int[] it: ls){
            if(Math.max(start, it[0]) < Math.min(end, it[1]))
            {
                if(!overlap.book(Math.max(start, it[0]) , Math.min(end, it[1]))) return false;
            }
        }
        ls.add(new int[]{start, end});
        return true;
    }
}
class MyCalendar{
    List<int[]> ls = new ArrayList<>();
    public boolean book(int s,int e){
        for(int it[]: ls){
            if(Math.max(s, it[0]) < Math.min(e, it[1])) return false;
        }
        ls.add(new int[]{ s, e});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */