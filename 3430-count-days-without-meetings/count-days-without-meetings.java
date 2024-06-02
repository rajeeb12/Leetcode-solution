class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        List<int[]> ls= new ArrayList<>();
        int sday = meetings[0][0];
        int eday = meetings[0][1];
        int count = sday - 1; 
        for(int i= 1; i < meetings.length; i++){
            if(eday >= meetings[i][0]){
                sday = Math.min(sday, meetings[i][0]);
                eday = Math.max(eday, meetings[i][1]);
            }
            else{
                count += meetings[i][0] - 1 - eday;
                int[] temp = new int[2];
                temp[0] = sday;
                temp[1] = eday;
                ls.add(temp);
                sday = meetings[i][0];
                eday = meetings[i][1];
            }
        }
        count += days - eday;
        return count;
    }
}