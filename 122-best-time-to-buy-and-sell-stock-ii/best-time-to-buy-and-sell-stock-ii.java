class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n + 1][2];
        for(int i[]: dp) Arrays.fill(i, -1);
        //1 -> buy
        //0-> sell
        return solve(0, prices, 1);
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