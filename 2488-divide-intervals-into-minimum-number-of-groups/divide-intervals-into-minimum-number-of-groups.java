class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int start[] = new int[n];
        int end[] = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int endPtr = 0;
        int group = 0;
        for(int startValue: start){
            if(startValue > end[endPtr]){
                endPtr++;
            }else{
                group++;
            }
        }
        return group++;
    }
}