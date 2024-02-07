class Solution {
    int n;
    int dp[][];
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n + 1][2];
        for(int i[]: dp) Arrays.fill(i, -1);
        return solve(0, prices,0);
    }
    // 0 - > sell , 1 -> buy
    public int solve(int i,int[] prices,int buy)
    {
        if(i >= n) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 0)
        {
            return dp[i][buy] = Math.max(-prices[i] + solve(i + 1, prices, 1) , solve(i + 1, prices, 0));
        }
        else{
            return dp[i][buy] = Math.max(prices[i] + solve(i + 2, prices, 0) , solve(i + 1, prices, 1));
        }
    }
}