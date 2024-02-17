class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        int next1 = 0;
        int next2 = 0;
        int cur = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            cur = Math.min(cost[i] + next1, cost[i] + next2);
            next1 = next2;
            next2 = cur;   
        }
        return Math.min(cur , next1);
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