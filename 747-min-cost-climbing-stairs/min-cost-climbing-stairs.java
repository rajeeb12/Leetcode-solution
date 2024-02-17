class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(solve(0,cost), solve(1,cost));
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