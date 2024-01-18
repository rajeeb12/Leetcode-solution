class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b [0]);
        int n = intervals.length;

        int start = intervals[0][0];
        int end = intervals[0][1];

        ArrayList<int[]> ans = new ArrayList<>();
        for(int i = 1; i < n; i++)
        {
            if(end >= intervals[i][0])
            {
                end = Math.max(end, intervals[i][1]);
            }
            else{
                ans.add(new int[]{start , end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start, end});

        int res[][]=new int[ans.size()][2];
        int index = 0;
        for(int i[]: ans)
        {
            res[index][0] = i[0];
            res[index][1] = i[1];
            index++;
        }
        return res;
    }
}