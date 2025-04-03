class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        
        List<int[]> temp = new ArrayList<>();
        List<int[]> temp2 = new ArrayList<>();
        temp2.add(newInterval);

        for(int i[]: intervals) temp2.add(i);
        
        Collections.sort(temp2, (a, b) -> a[0] - b[0]);
        int start = temp2.get(0)[0];
        int end = temp2.get(0)[1];

        for(int i = 1; i < temp2.size(); i++){
            if(temp2.get(i)[0] <= end){
                start = Math.min(start, temp2.get(i)[0]);
                end = Math.max(end, temp2.get(i)[1]);
            }else{
                temp.add(new int[]{start, end});
                start = temp2.get(i)[0];
                end = temp2.get(i)[1];
            }
        }
        temp.add(new int[]{start, end});
        int ans[][] = new int[temp.size()][2];
        int index = 0 ;
        for(int i[]: temp){
            ans[index][0] = i[0];
            ans[index][1] = i[1];
            index++;
        }
        return ans;
    }
}