class Solution {
    int dp[];
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);

        int ans = solve(costs, days,0);
        return (ans == (int)1e9 ? 0: ans);
    }
    public int solve(int[] costs,int[] days,int skip)
    {
        int n = days.length;
        if(skip >= days.length){
            return 0;
        }

        if(dp[skip] != -1) return dp[skip];

        int oneDay = costs[0] + solve(costs,days, skip + 1);
        int sevenDay = (int)1e9, thirtyDay = (int)1e9;

        int i;
        for(i = skip; i < n && days[i] < days[skip] + 7; i++);

        sevenDay = costs[1] + solve(costs, days, i);

        for(i = skip; i < n && days[i] < days[skip] + 30; i++);

        thirtyDay = costs[2] + solve(costs, days, i);

        return dp[skip] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }
}