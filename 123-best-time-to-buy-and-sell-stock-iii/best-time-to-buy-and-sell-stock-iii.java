class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n + 1][3][2];
        for(int i[][]: dp)
        {
            for(int j[]: i)
            {
                Arrays.fill(j, -1);
            }
        }
        return solve(0,prices, 2,1);
    }
    public int solve(int i,int[] prices,int t,int buy)
    {
        int n = prices.length;
        if(i == n || t == 0){
            return 0;
        }

        if(dp[i][t][buy] != -1) return dp[i][t][buy];

        if(buy == 1)
        {
            return dp[i][t][buy] = Math.max(-prices[i] + solve(i + 1, prices, t, 1 - buy) , solve(i + 1, prices,t, buy));
        }
        else{
            return dp[i][t][buy] = Math.max(prices[i] + solve(i + 1, prices, t - 1, 1 - buy) , solve(i + 1, prices, t , buy));
        }
    }
}