class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        ArrayList<int[]> temp = new ArrayList<>();
        int n = intervals.length;
        for(int interval[]: intervals)
        {
            if(interval[1] < newInterval[0])
            {
                temp.add(interval);
            }else if(interval[0] > newInterval[1])
            {
                temp.add(newInterval);
                newInterval = interval;
            }else{
                newInterval[0] = Math.min(newInterval[0],interval[0]);
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }
        }
        temp.add(newInterval);
        int index = 0;
        int ans[][]= new int[temp.size()][2];

        for(int i[]: temp)
        {
            ans[index][0] = i[0];
            ans[index][1] = i[1];
            index++;
        }
        return ans;
    }
}