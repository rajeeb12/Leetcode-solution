class Solution {
    int n;
    int dp[][];
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new int[n+1][2];
        for(int i[]: dp) Arrays.fill(i, -1);
        
        return solve(0,0,fee,prices);
    }
    public int solve(int i,int buy,int fee,int[] prices)
    {
        if(i == n)
        {
            return 0;
        }
        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 0)
        {
            return dp[i][buy] = Math.max(-prices[i] + solve(i + 1, 1, fee, prices), solve(i + 1, 0, fee, prices));
        }
        else
        {
            return dp[i][buy] = Math.max(prices[i] - fee + solve(i + 1, 0, fee, prices) , solve(i + 1, 1, fee , prices));
        }
    } 
}