class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) return true;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){
                return false;
            }else{
                end = intervals[i][1];
            }
        }
        return true;
    }
}