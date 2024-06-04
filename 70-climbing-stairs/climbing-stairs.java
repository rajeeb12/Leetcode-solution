class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        //return solve(n);
    }
    public int solve(int n)
    {
        if(n == 1 || n == 0) return 1;
        if(dp[n] != -1) return dp[n];

        return dp[n] = solve(n - 1) + solve(n - 2);
    }
}