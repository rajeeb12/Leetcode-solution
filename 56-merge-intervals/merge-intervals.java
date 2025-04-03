class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> temp = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < n; i++){
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
        int index = 0;
        for(int i[]: temp){
            ans[index][0] = i[0];
            ans[index][1] = i[1];
            index++;
        }
        return ans;
    }
}