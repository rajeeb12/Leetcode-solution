class Solution {
    int dp[];
    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp ,-1);
        return solve(n);
    }
    public int solve(int n)
    {
        if(n == 0)
        {
            return 0;
        }
        if(dp[n] != -1) return dp[n];
        
        int ans = (int)1e9;
        for(int i = 1; i * i <= n; i++)
        {
            ans = Math.min(1 + solve(n - i *i), ans);
        }
        return dp[n] = ans;

    }
}