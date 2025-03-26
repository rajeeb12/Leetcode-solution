class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int startTime[] = new int[n];
        int endTime[] = new int[n];

        int index = 0;
        for(int interval[] : intervals){
            startTime[index] = interval[0];
            endTime[index] = interval[1];
            index++;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int i = 0, j = 0;
        int count = 0, max = 0;

        while(i < n && j < n){
            if(startTime[i] < endTime[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}