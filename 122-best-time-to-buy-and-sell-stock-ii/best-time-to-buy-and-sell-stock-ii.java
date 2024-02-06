class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n + 1][2];
        
        for(int i = n - 1; i >=0 ; i--)
        {
            for(int buyOrSell = 0 ; buyOrSell <= 1; buyOrSell++)
            {
                if(buyOrSell == 1)
                {
                    dp[i][buyOrSell] =Math.max(-prices[i] + dp[i + 1][1 -  buyOrSell] , dp[i + 1][ buyOrSell]);
                }
                else{
                    dp[i][buyOrSell]= Math.max(prices[i] + dp[i + 1][1 - buyOrSell] , dp[i + 1][ buyOrSell]);
                }
            }
        }
        return dp[0][1];
        //return solve(0, prices, 1);
    }
    public int solve(int i, int prices[], int buyOrSell)
    {
        int n = prices.length; 
        if(i == n)
        {
            return 0;
        }
        if(dp[i][buyOrSell] != -1) return dp[i][buyOrSell];

        if(buyOrSell == 1)
        {
            return dp[i][buyOrSell] =Math.max(-prices[i] + solve(i + 1, prices, 1 - buyOrSell) , solve(i + 1, prices,buyOrSell));
        }
        else{
            return dp[i][buyOrSell]= Math.max(prices[i] + solve(i + 1, prices, 1 - buyOrSell) , solve(i + 1, prices, buyOrSell));
        }
    }
}