class Solution {
    public int[][] insert(int[][] intervals, int[] nI) {
        ArrayList<int[]> temp = new ArrayList<>();
        
        for(int[] i : intervals)
        {
            if(i[1] < nI[0])
            {
                temp.add(i);
            }else if(i[0] > nI[1])
            {
                temp.add(nI);
                nI = i;
            }else{
                nI[0] = Math.min(nI[0], i[0]);
                nI[1] = Math.max(i[1], nI[1]);
            }
        }
        temp.add(nI);
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