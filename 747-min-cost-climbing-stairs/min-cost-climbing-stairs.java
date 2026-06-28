class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(solve(0, cost), solve(1, cost));
    }
    public int solve(int index, int cost[]){
        if(index >= cost.length) return 0;

        if(dp[index] != -1) return dp[index];

        return dp[index] = cost[index] + Math.min(solve(index + 1, cost) , solve(index + 2, cost));
    }
}