class Solution {
    int n;
    int dp[][][];
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        dp = new int[n + 1][2][k + 1];
        for(int i[][] :dp)
        {
            for(int j[]: i)
            {
                Arrays.fill(j, -1);
            }
        }
        return solve(prices,0,1,k);
    }
    public int solve(int[] prices,int i,int buy,int k)
    {
        if(i == n || k == 0)
        {
            return 0;
        }
        if(dp[i][buy][k] != -1) return dp[i][buy][k];

        if(buy == 1)
        {
            return dp[i][buy][k] = Math.max(-prices[i] + solve(prices, i + 1 , 0, k) , solve(prices,i + 1 , 1 , k));
        }
        else{
            return dp[i][buy][k] = Math.max(prices[i] + solve(prices, i + 1 , 1, k - 1) , solve(prices, i + 1 , 0 , k));
        }
    }
}