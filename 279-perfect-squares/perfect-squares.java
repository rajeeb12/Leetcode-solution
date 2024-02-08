class Solution {
    int dp[];
    public int numSquares(int j) {
        dp = new int[j + 1];

        for(int n = 1 ; n <= j; n++)
        {
            int ans = (int)1e9;
            for(int i = 1; i * i <= n; i++)
            {
                ans = Math.min(1 + dp[n - i *i], ans);
            }
            dp[n] = ans;
        }
        return dp[j];
        //return solve(i);
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