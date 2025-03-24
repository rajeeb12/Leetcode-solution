class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= end){
                start = Math.min(intervals[i][0], start);
                end = Math.max(intervals[i][1], end);
            }else{
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});
        int ans[][] = new int[list.size()][2];

        for(int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}