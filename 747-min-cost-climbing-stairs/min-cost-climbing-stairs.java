class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        dp[n - 1] = cost[n - 1];
        for(int i = n - 2; i >= 0; i--){
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
    public int solve(int index, int cost[]){
        if(index >= cost.length) return 0;

        if(dp[index] != -1) return dp[index];

        return dp[index] = cost[index] + Math.min(solve(index + 1, cost) , solve(index + 2, cost));
    }
}