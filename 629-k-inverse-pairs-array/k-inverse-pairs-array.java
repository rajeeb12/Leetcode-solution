class Solution {
    int dp[][];
    int mod;
    public int kInversePairs(int n, int k) {
        dp = new int[n + 1][k + 1];
        for(int i[]: dp) Arrays.fill(i, - 1);
        mod = (int)1e9 + 7;
        return solve(n , k);
    }
    public int solve(int n,int k)
    {
        if(n == 0) return 0;
        if(k == 0)
        {
            return 1;
        }
        if(dp[n][k] != -1) return dp[n][k];
        int res = 0;
        for(int i = 0; i <= Math.min(n - 1 , k) ; i++)
        {
            res = (res + solve(n - 1 , k - i)) % mod;
        }
        return dp[n][k] = res % mod;
    }
}