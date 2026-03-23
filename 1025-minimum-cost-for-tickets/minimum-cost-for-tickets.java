class Solution {
    int dp[];
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length + 1];
        
        for(int index = days.length - 1; index >= 0 ; index--){
            int one = costs[0] + dp[index + 1];
            int maxDaysForSevenDaysPass = days[index] + 7;
            int j = index;
            while(j < days.length && days[j] < maxDaysForSevenDaysPass){
                j++;
            }
            int seven = costs[1] + dp[j];
            int maxDaysForThirtyDaysPass = days[index] + 30;
            j = index;
            while(j < days.length && days[j] < maxDaysForThirtyDaysPass){
                j++;
            }
            int thirty = costs[2] + dp[j];

            dp[index] = Math.min(one, Math.min(seven, thirty));
        }
        return dp[0];
    }
    public int solve(int index,int days[],int costs[]){
        if(index >= days.length) return 0;

        if(dp[index] != -1) return dp[index];

        int one = costs[0] + solve(index + 1, days, costs);
        int maxDaysForSevenDaysPass = days[index] + 7;
        int j = index;
        while(j < days.length && days[j] < maxDaysForSevenDaysPass){
            j++;
        }
        int seven = costs[1] + solve(j, days, costs);
        int maxDaysForThirtyDaysPass = days[index] + 30;
        j = index;
        while(j < days.length && days[j] < maxDaysForThirtyDaysPass){
            j++;
        }
        int thirty = costs[2] + solve(j, days, costs);

        return dp[index] = Math.min(one, Math.min(seven, thirty));
    }
}