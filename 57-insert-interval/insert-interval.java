class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> temp = new ArrayList<>();
        int index = 0;
        while(index < n && intervals[index][1] < newInterval[0]){
            temp.add(new int[]{intervals[index][0],intervals[index][1]});
            index++;
        }

        int start = newInterval[0];
        int end = newInterval[1];

        for(int i = index; i < n; i++){
            if(intervals[i][0] <= end){
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }else{
                temp.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        temp.add(new int[]{start, end});
        int ans[][] = new int[temp.size()][2];
        int index2 = 0;
        for(int i[]: temp){
            ans[index2][0] = i[0];
            ans[index2][1] = i[1];
            index2++;
        }
        return ans;
    }
}