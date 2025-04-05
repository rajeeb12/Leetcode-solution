class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int startTime[] = new int[n];
        int endTime[] = new int[n];
        
        for(int index = 0;index < n; index++){
            startTime[index] = intervals[index][0];
            endTime[index] = intervals[index][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int count = 0, max=0;

        for(int i = 0, j = 0; i < n && j < n;){
            if(startTime[i] < endTime[j]){
                count++;
                i++;
            }else
            {
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    // 1 6 13
    // 9 13 15
}