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
        int count = start - 1;
        for(int i = 1; i < meetings.length; i++){
            if(meetings[i][0] <= end){
                end = Math.max(meetings[i][1], end);
                start = Math.min(start, meetings[i][0]);
            }else{
                count += meetings[i][0] - end - 1;
                start = meetings[i][0];
                end = meetings[i][1];
            }
        }
        count += days - end;
        return count;

    }
}