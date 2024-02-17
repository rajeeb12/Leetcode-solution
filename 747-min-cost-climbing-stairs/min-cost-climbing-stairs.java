class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 2];
        for(int i = n - 1; i >= 0; i--)
        {
            dp[i] = Math.min(cost[i] + dp[i + 1], cost[i] + dp[i + 2]);   
        }
        return Math.min(dp[0] , dp[1]);
    }
    public int solve(int i,int[] cost)
    {
        if(i >= cost.length)
        {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        return dp[i] = Math.min(cost[i] + solve(i + 1, cost), cost[i] + solve(i + 2, cost));
    }
}