class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> temp = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];

        for(int[] i: intervals)
        {
            if(i[1] < newInterval[0])
            {
                temp.add(i);
            }else if(i[0] > newInterval[1])
            {
                temp.add(newInterval);
                newInterval = i;
            }else{
                newInterval[0] = Math.min(newInterval[0], i[0]);
                newInterval[1] = Math.max(newInterval[1] , i[1]);
            }
        }
        temp.add(new int[]{newInterval[0], newInterval[1]});
        int ans[][] = new int[temp.size()][2];
        int index = 0;
        for(int i[]: temp)
        {
            ans[index][0] = i[0];
            ans[index][1] = i[1];
            index++;
        }
        return ans;
    }
}