class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                if(a[0] == b[0]){
                    return Integer.compare(a[1] ,b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });

        int start = meetings[0][0];
        int end = meetings[0][1];
        List<int[]> temp = new ArrayList<>();
        for(int i = 1; i < meetings.length; i++){
            if(meetings[i][0] <= end){
                end = Math.max(meetings[i][1], end);
                start = Math.min(start, meetings[i][0]);
            }else{
                temp.add(new int[]{start, end});
                start = meetings[i][0];
                end = meetings[i][1];
            }
        }
        temp.add(new int[]{start, end});
        int count = temp.get(0)[0] - 1;

        for(int i = 1; i < temp.size(); i++){
            int prev[] = temp.get(i - 1);
            int cur[] = temp.get(i);
            count += cur[0] - prev[1] - 1;
        }
        count += days - temp.get(temp.size() - 1)[1];
        return count;

    }
}